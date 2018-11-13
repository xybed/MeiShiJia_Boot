package com.qiqi.msjorder.service;

import com.qiqi.msjmapper.dto.ShoppingCartDto;
import com.qiqi.msjmapper.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    List<ShoppingCartDto> getShoppingCarts(Integer userId, Integer pageIndex, Integer pageSize);

    void addShoppingCart(ShoppingCart shoppingCart);
}
