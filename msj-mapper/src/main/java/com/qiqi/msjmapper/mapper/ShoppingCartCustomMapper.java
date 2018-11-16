package com.qiqi.msjmapper.mapper;

import com.qiqi.msjmapper.dto.ShoppingCartDto;
import com.qiqi.msjmapper.entity.ShoppingCart;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ShoppingCartCustomMapper {
    List<ShoppingCartDto> queryShoppingCart(@Param("userId") Integer userId, @Param("status") Integer status);

    ShoppingCartDto queryShoppingCartByProductId(@Param("userId") Integer userId, @Param("productId") Integer productId, @Param("status") Integer status);

    int updateByPrimaryKeySelective(ShoppingCart record);

    int queryShoppingCartCount(@Param("userId") Integer userId, @Param("status") Integer status);

    int insertSelective(ShoppingCart record);

    int updateShoppingCartStatus(@Param("idList") List<Integer> idList, @Param("status") Integer status, @Param("gmtModified") Date gmtModified);
}