package com.qiqi.msjorder.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.qiqi.commonconfig.common.Constants;
import com.qiqi.commonconfig.common.ResultEnum;
import com.qiqi.commonconfig.common.ServiceException;
import com.qiqi.commonlib.utils.NumberUtil;
import com.qiqi.commonlib.utils.OrderNumberUtil;
import com.qiqi.msjmapper.dto.OrderDto;
import com.qiqi.msjmapper.dto.ProductDto;
import com.qiqi.msjmapper.dto.ShoppingCartDto;
import com.qiqi.msjmapper.entity.Order;
import com.qiqi.msjmapper.entity.OrderShoppingCart;
import com.qiqi.msjmapper.enums.OrderStatus;
import com.qiqi.msjmapper.enums.ProductStatus;
import com.qiqi.msjmapper.enums.ShoppingCartStatus;
import com.qiqi.msjmapper.mapper.OrderCustomMapper;
import com.qiqi.msjmapper.mapper.OrderShoppingCartCustomMapper;
import com.qiqi.msjmapper.mapper.ShoppingCartCustomMapper;
import com.qiqi.msjorder.remote.ProductRemote;
import com.qiqi.msjorder.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private ShoppingCartCustomMapper shoppingCartCustomMapper;
    @Resource
    private ProductRemote productRemote;
    @Resource
    private OrderCustomMapper orderCustomMapper;
    @Resource
    private OrderShoppingCartCustomMapper orderShoppingCartCustomMapper;

    /**
     * 下单
     * 1.查询购物车中的商品id列表
     * 2.去商品服务中，查询对应商品的库存
     * 3.如果库存不足，提示库存不足
     * 4.下单，修改shopping_cart表状态，插入一条order记录，批量插入order_shopping_cart记录
     * @param dtoList 购物车列表，包含id和remark
     * @param receivingAddressId 收货地址id
     */
    @Transactional
    @Override
    public int placeOrder(List<ShoppingCartDto> dtoList, Integer receivingAddressId) {
        List<Integer> idList = new ArrayList<>();
        dtoList.forEach(dto -> {
            idList.add(dto.getId());
        });
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
                        if(product.getStatus().intValue() == ProductStatus.LOWER.getCode()){
                            throw new ServiceException(ResultEnum.PRODUCT_LOWER_ERROR);
                        }
                        if(shoppingCartDto.getShoppingCartStatus().intValue() != ShoppingCartStatus.EFFECTIVE.getCode()){
                            throw new ServiceException(ResultEnum.SHOPPING_CART_STATUS_ERROR);
                        }
                        shoppingCartDto.setName(product.getName());
                        shoppingCartDto.setImage(product.getImage());
                        shoppingCartDto.setPrice(product.getPrice());
                        shoppingCartDto.setOriginalPrice(product.getOriginalPrice());
                        shoppingCartDto.setDiscountPrice(product.getDiscountPrice());
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
        order.setReceivingAddressId(receivingAddressId);
        double totalAmount = 0;
        for(ShoppingCartDto shoppingCartDto : shoppingCartDtoList){
            totalAmount = NumberUtil.add(totalAmount, NumberUtil.multiply(shoppingCartDto.getPrice().doubleValue(), shoppingCartDto.getNum()));
        }
        order.setPayAmount(new BigDecimal(totalAmount).setScale(2, BigDecimal.ROUND_HALF_EVEN));
        order.setStatus(OrderStatus.WAIT_PAY.getCode());
        order.setGmtCreate(new Date());
        orderCustomMapper.insertSelective(order);
        //批量插入order_shopping_cart记录
        List<OrderShoppingCart> orderShoppingCartList = new ArrayList<>();
        shoppingCartDtoList.forEach(shoppingCartDto -> {
            OrderShoppingCart orderShoppingCart = new OrderShoppingCart();
            orderShoppingCart.setOrderId(order.getId());
            orderShoppingCart.setShoppingCartId(shoppingCartDto.getId());
            orderShoppingCart.setName(shoppingCartDto.getName());
            orderShoppingCart.setImage(shoppingCartDto.getImage().substring(Constants.URL_PREFIX.length()));
            orderShoppingCart.setPrice(shoppingCartDto.getPrice());
            orderShoppingCart.setOriginalPrice(shoppingCartDto.getOriginalPrice());
            orderShoppingCart.setDiscountPrice(shoppingCartDto.getDiscountPrice());
            for(ShoppingCartDto dto : dtoList){
                if(dto.getId().intValue() == shoppingCartDto.getId()){
                    if(StringUtils.isEmpty(dto.getRemark())){
                        orderShoppingCart.setRemark("");
                    }else {
                        orderShoppingCart.setRemark(dto.getRemark());
                    }
                }
            }
            orderShoppingCartList.add(orderShoppingCart);
        });
        orderShoppingCartCustomMapper.insertBatch(orderShoppingCartList);
        return order.getId();
    }

    @Override
    public List<OrderDto> getOrderList(Integer userId, Integer type, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<OrderDto> orderList = orderCustomMapper.queryOrderByStatus(userId, type);
        orderList.forEach(order -> {
            order.getProducts().forEach(product -> {
                product.setImage(Constants.URL_PREFIX + product.getImage());
            });
        });
        return orderList;
    }

    @Override
    public OrderDto getOrderDetail(Integer id) {
        OrderDto order = orderCustomMapper.queryOrderDetail(id);
        order.getProducts().forEach(product -> {
            product.setImage(Constants.URL_PREFIX + product.getImage());
        });
        return order;
    }
}
