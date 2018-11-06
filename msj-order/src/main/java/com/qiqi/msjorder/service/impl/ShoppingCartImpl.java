package com.qiqi.msjorder.service.impl;

import com.qiqi.msjmapper.entity.ShoppingCart;
import com.qiqi.msjorder.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartImpl implements ShoppingCartService {

    @Override
    public List<ShoppingCart> getShoppingCarts(Integer userId, Integer pageIndex, Integer pageSize) {
        return null;
    }
}
