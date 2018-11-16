package com.qiqi.msjmapper.mapper;

import com.qiqi.msjmapper.entity.Order;

public interface OrderCustomMapper {
    int insertSelective(Order record);
}