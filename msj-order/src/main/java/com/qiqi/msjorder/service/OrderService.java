package com.qiqi.msjorder.service;

import com.qiqi.msjmapper.dto.ShoppingCartDto;

import java.util.List;

public interface OrderService {
    void order(List<ShoppingCartDto> idList, Integer receivingAddressId);
}
