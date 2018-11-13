package com.qiqi.msjorder.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.qiqi.commonconfig.common.ResultEnum;
import com.qiqi.commonconfig.common.ServiceException;
import com.qiqi.msjmapper.dto.ProductDto;
import com.qiqi.msjmapper.dto.ShoppingCartDto;
import com.qiqi.msjmapper.entity.ShoppingCart;
import com.qiqi.msjmapper.enums.ShoppingCartStatus;
import com.qiqi.msjmapper.mapper.ShoppingCartCustomMapper;
import com.qiqi.msjorder.remote.ProductRemote;
import com.qiqi.msjorder.service.ShoppingCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ShoppingCartImpl implements ShoppingCartService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ShoppingCartCustomMapper shoppingCartCustomMapper;
    @Resource
    private ProductRemote productRemote;

    /**
     * 1.根据用户id和购物车状态查询购物车列表
     * 2.如果不为空，去商品服务下查询对应商品信息
     * 3.如果商品信息列表不为空（断路或服务异常会为空），赋值给对应购物车
     * @param userId 用户id
     * @param pageIndex 页码
     * @param pageSize 一页数
     * @return 购物车列表
     */
    @Override
    public List<ShoppingCartDto> getShoppingCarts(Integer userId, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<ShoppingCartDto> shoppingCartList = shoppingCartCustomMapper.queryShoppingCart(userId, ShoppingCartStatus.EFFECTIVE.getCode());
        List<Integer> idList = new ArrayList<>();
        shoppingCartList.forEach(shoppingCart -> {
            idList.add(shoppingCart.getProductId());
        });
        if(idList.size() > 0){
            List<ProductDto> productList = productRemote.getProductShoppingCart(JSON.toJSONString(idList));
            if(productList != null){
                productList.forEach(product -> {
                    for(ShoppingCartDto shoppingCart : shoppingCartList){
                        if(product.getId().intValue() == shoppingCart.getProductId()){
                            shoppingCart.setName(product.getName());
                            shoppingCart.setImage(product.getImage());
                            shoppingCart.setPrice(product.getPrice());
                            if(product.getOriginalPrice() == null)
                                logger.info("原价为空");
                            if(product.getDiscountPrice() == null)
                                logger.info("折价为空");
                            shoppingCart.setOriginalPrice(product.getOriginalPrice());
                            shoppingCart.setDiscountPrice(product.getDiscountPrice());
                            break;
                        }
                    }
                });
            }
        }
        return shoppingCartList;
    }

    /**
     * 添加购物车
     * 1.查询此条商品库存是否充足
     * 2.若充足，则插入一条数据
     * @param shoppingCart 商品数据
     */
    @Override
    public void addShoppingCart(ShoppingCart shoppingCart) {
        Integer stock = productRemote.getProductStock(shoppingCart.getProductId());
        if(stock < shoppingCart.getNum())
            throw new ServiceException(ResultEnum.PRODUCT_STOCK_NOT_ENOUGH);
        shoppingCart.setStatus(ShoppingCartStatus.EFFECTIVE.getCode());
        shoppingCart.setGmtCreate(new Date());
        int result = shoppingCartCustomMapper.insertSelective(shoppingCart);
        if(result != 1)
            throw new ServiceException(ResultEnum.OPERATE_ERROR);
    }
}
