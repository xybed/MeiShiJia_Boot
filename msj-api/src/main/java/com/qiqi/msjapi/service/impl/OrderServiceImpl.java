package com.qiqi.msjapi.service.impl;

import com.qiqi.msjapi.service.OrderService;
import com.qiqi.msjmapper.dto.ReceivingAddressDto;
import com.qiqi.msjmapper.enums.ReceivingAddressStatus;
import com.qiqi.msjmapper.mapper.ReceivingAddressCustomMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private ReceivingAddressCustomMapper receivingAddressCustomMapper;

    @Override
    public List<ReceivingAddressDto> getReceivingAddress(Integer userId) {
        return receivingAddressCustomMapper.queryReceivingAddress(userId, ReceivingAddressStatus.EFFECTIVE.getCode());
    }
}
