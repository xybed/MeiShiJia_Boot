package com.qiqi.msjmapper.mapper;

import com.qiqi.msjmapper.dto.ShoppingCartDto;
import com.qiqi.msjmapper.entity.ShoppingCart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShoppingCartCustomMapper {
    List<ShoppingCartDto> queryShoppingCart(@Param("userId") Integer userId, @Param("status") Integer status);

    int insertSelective(ShoppingCart record);
}