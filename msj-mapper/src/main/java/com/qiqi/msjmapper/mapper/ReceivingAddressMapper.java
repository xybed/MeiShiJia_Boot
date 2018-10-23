package com.qiqi.msjmapper.mapper;

import com.qiqi.msjmapper.entity.ReceivingAddress;

public interface ReceivingAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReceivingAddress record);

    int insertSelective(ReceivingAddress record);

    ReceivingAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReceivingAddress record);

    int updateByPrimaryKey(ReceivingAddress record);
}