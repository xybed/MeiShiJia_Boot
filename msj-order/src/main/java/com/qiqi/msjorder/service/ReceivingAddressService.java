package com.qiqi.msjorder.service;

import com.qiqi.msjmapper.dto.ReceivingAddressDto;
import com.qiqi.msjmapper.entity.ReceivingAddress;

import java.util.List;

public interface ReceivingAddressService {
    List<ReceivingAddressDto> getReceivingAddress(Integer userId);

    void addReceivingAddress(ReceivingAddress receivingAddress);

    void updateReceivingAddress(ReceivingAddress receivingAddress);

    void deleteReceivingAddress(Integer id);

    ReceivingAddressDto getDefaultReceivingAddress(Integer userId);
}
