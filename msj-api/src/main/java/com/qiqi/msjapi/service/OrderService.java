package com.qiqi.msjapi.service;

import com.qiqi.msjmapper.dto.ReceivingAddressDto;
import com.qiqi.msjmapper.entity.ReceivingAddress;

import java.util.List;

public interface OrderService {
    List<ReceivingAddressDto> getReceivingAddress(Integer userId);

    void addReceivingAddress(ReceivingAddress receivingAddress);

    void updateReceivingAddress(ReceivingAddress receivingAddress);

    void deleteReceivingAddress(Integer id);
}
