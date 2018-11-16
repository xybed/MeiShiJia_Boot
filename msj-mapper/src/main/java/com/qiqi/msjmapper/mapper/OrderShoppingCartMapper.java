package com.qiqi.msjmapper.mapper;

import com.qiqi.msjmapper.entity.OrderShoppingCart;

public interface OrderShoppingCartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderShoppingCart record);

    int insertSelective(OrderShoppingCart record);

    OrderShoppingCart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderShoppingCart record);

    int updateByPrimaryKey(OrderShoppingCart record);
}