package com.qiqi.msjmapper.mapper;

import com.qiqi.msjmapper.entity.ShoppingCart;

public interface ShoppingCartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShoppingCart record);

    int insertSelective(ShoppingCart record);

    ShoppingCart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShoppingCart record);

    int updateByPrimaryKey(ShoppingCart record);
}