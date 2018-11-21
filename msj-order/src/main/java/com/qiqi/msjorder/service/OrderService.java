package com.qiqi.msjorder.service;

import com.qiqi.msjmapper.dto.OrderDto;
import com.qiqi.msjmapper.dto.ShoppingCartDto;

import java.util.List;

public interface OrderService {
    int placeOrder(List<ShoppingCartDto> idList, Integer receivingAddressId);

    List<OrderDto> getOrderList(Integer userId, Integer type, Integer pageIndex, Integer pageSize);

    OrderDto getOrderDetail(Integer id);
}
