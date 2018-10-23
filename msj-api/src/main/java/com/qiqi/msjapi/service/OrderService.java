package com.qiqi.msjapi.service;

import com.qiqi.msjmapper.dto.ReceivingAddressDto;

import java.util.List;

public interface OrderService {
    List<ReceivingAddressDto> getReceivingAddress(Integer userId);
}
