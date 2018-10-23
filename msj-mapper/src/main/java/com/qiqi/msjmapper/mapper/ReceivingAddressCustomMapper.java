package com.qiqi.msjmapper.mapper;

import com.qiqi.msjmapper.dto.ReceivingAddressDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReceivingAddressCustomMapper {
    List<ReceivingAddressDto> queryReceivingAddress(@Param("userId") Integer userId, @Param("status") Integer status);
}