package com.qiqi.msjorder.service.impl;

import com.alibaba.fastjson.JSON;
import com.qiqi.commonconfig.common.ResultEnum;
import com.qiqi.commonconfig.common.ServiceException;
import com.qiqi.commonlib.utils.OrderNumberUtil;
import com.qiqi.msjmapper.dto.ProductDto;
import com.qiqi.msjmapper.dto.ShoppingCartDto;
import com.qiqi.msjmapper.entity.Order;
import com.qiqi.msjmapper.entity.ShoppingCart;
import com.qiqi.msjmapper.enums.ShoppingCartStatus;
import com.qiqi.msjmapper.mapper.ShoppingCartCustomMapper;
import com.qiqi.msjorder.remote.ProductRemote;
import com.qiqi.msjorder.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private ShoppingCartCustomMapper shoppingCartCustomMapper;
    @Resource
    private ProductRemote productRemote;

    /**
     * 下单
     * 1.查询购物车中的商品id列表
     * 2.去商品服务中，查询对应商品的库存
     * 3.如果库存不足，提示库存不足
     * 4.下单，修改shopping_cart表状态，插入一条order记录，批量插入order_shopping_cart记录
     * @param idList 购物车id列表
     * @param receivingAddressId 收货地址id
     */
    @Transactional
    @Override
    public void order(List<Integer> idList, Integer receivingAddressId) {
        List<ShoppingCartDto> shoppingCartDtoList = shoppingCartCustomMapper.queryShoppingCartByIdList(idList);
        List<Integer> productIdList = new ArrayList<>();
        shoppingCartDtoList.forEach(shoppingCartDto -> {
            productIdList.add(shoppingCartDto.getProductId());
        });
        List<ProductDto> productList = productRemote.getProductShoppingCart(JSON.toJSONString(productIdList));
        if(productList != null) {
            productList.forEach(product -> {
                for(ShoppingCartDto shoppingCartDto: shoppingCartDtoList){
                    if(product.getId().intValue() == shoppingCartDto.getProductId()){
                        if(product.getStock() < shoppingCartDto.getNum()){
                            throw new ServiceException(ResultEnum.PRODUCT_STOCK_NOT_ENOUGH);
                        }
                        break;
                    }
                }
            });
        }
        //开始下单
        //修改shopping_cart表状态
        shoppingCartCustomMapper.updateShoppingCartStatus(idList, ShoppingCartStatus.ORDER.getCode(), new Date());
        //插入一条order记录
        Order order = new Order();
        order.setOrderNumber(OrderNumberUtil.getOrderNumberByUUId());
    }
}
