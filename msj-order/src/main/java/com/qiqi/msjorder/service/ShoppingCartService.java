package com.qiqi.msjorder.service;

import com.qiqi.msjmapper.dto.ShoppingCartDto;
import com.qiqi.msjmapper.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    List<ShoppingCartDto> getShoppingCarts(Integer userId);

    void addShoppingCart(ShoppingCart shoppingCart);
}
