package com.qiqi.msjmapper.mapper;

import com.qiqi.msjmapper.entity.OrderShoppingCart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderShoppingCartCustomMapper {
    int insertBatch(@Param("list")List<OrderShoppingCart> orderShoppingCartList);
}