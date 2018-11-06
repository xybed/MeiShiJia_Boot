package com.qiqi.msjorder.service;

import com.qiqi.msjmapper.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    List<ShoppingCart> getShoppingCarts(Integer userId, Integer pageIndex, Integer pageSize);
}
