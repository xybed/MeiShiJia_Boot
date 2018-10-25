package com.qiqi.msjorder.service.impl;

import com.qiqi.commonlib.common.ResultEnum;
import com.qiqi.commonlib.common.ServiceException;
import com.qiqi.msjmapper.dto.ReceivingAddressDto;
import com.qiqi.msjmapper.entity.ReceivingAddress;
import com.qiqi.msjmapper.enums.ReceivingAddressStatus;
import com.qiqi.msjmapper.mapper.ReceivingAddressCustomMapper;
import com.qiqi.msjorder.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private ReceivingAddressCustomMapper receivingAddressCustomMapper;

    @Override
    public List<ReceivingAddressDto> getReceivingAddress(Integer userId) {
        return receivingAddressCustomMapper.queryReceivingAddress(userId, ReceivingAddressStatus.EFFECTIVE.getCode());
    }

    @Override
    public void addReceivingAddress(ReceivingAddress receivingAddress) {
        receivingAddress.setStatus(ReceivingAddressStatus.EFFECTIVE.getCode());
        receivingAddress.setGmtCreate(new Date());
        int result = receivingAddressCustomMapper.insertSelective(receivingAddress);
        if(result != 1)
            throw new ServiceException(ResultEnum.OPERATE_ERROR);
    }

    @Override
    public void updateReceivingAddress(ReceivingAddress receivingAddress) {
        receivingAddress.setGmtModified(new Date());
        int result = receivingAddressCustomMapper.updateByPrimaryKeySelective(receivingAddress);
        if(result != 1)
            throw new ServiceException(ResultEnum.OPERATE_ERROR);
    }

    @Override
    public void deleteReceivingAddress(Integer id) {
        ReceivingAddress receivingAddress = new ReceivingAddress();
        receivingAddress.setId(id);
        receivingAddress.setStatus(ReceivingAddressStatus.INEFFECTIVE.getCode());
        receivingAddress.setGmtModified(new Date());
        int result = receivingAddressCustomMapper.updateByPrimaryKeySelective(receivingAddress);
        if(result != 1)
            throw new ServiceException(ResultEnum.OPERATE_ERROR);
    }
}
