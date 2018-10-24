package com.qiqi.msjmapper.mapper;

import com.qiqi.msjmapper.dto.ReceivingAddressDto;
import com.qiqi.msjmapper.entity.ReceivingAddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReceivingAddressCustomMapper {
    List<ReceivingAddressDto> queryReceivingAddress(@Param("userId") Integer userId, @Param("status") Integer status);

    int insertSelective(ReceivingAddress record);

    int updateByPrimaryKeySelective(ReceivingAddress record);
}