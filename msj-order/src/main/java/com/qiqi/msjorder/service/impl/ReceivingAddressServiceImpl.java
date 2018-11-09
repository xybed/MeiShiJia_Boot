package com.qiqi.msjorder.service.impl;

import com.qiqi.commonconfig.common.ResultEnum;
import com.qiqi.commonconfig.common.ServiceException;
import com.qiqi.msjmapper.dto.ReceivingAddressDto;
import com.qiqi.msjmapper.entity.ReceivingAddress;
import com.qiqi.msjmapper.enums.ReceivingAddressStatus;
import com.qiqi.msjmapper.enums.ReceivingAddressType;
import com.qiqi.msjmapper.mapper.ReceivingAddressCustomMapper;
import com.qiqi.msjorder.service.ReceivingAddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ReceivingAddressServiceImpl implements ReceivingAddressService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ReceivingAddressCustomMapper receivingAddressCustomMapper;

    @Override
    public List<ReceivingAddressDto> getReceivingAddress(Integer userId) {
        return receivingAddressCustomMapper.queryReceivingAddress(userId, ReceivingAddressStatus.EFFECTIVE.getCode());
    }

    /**
     * 1.设置地址状态为有效，创建时间为当前时间
     * 2.查询数据中是否有10条数据，满了则不插入，没满到3
     * 3.如果是添加默认地址，把之前的默认地址修改掉
     * 4.插入一条新数据
     * @param receivingAddress 地址数据
     */
    @Transactional
    @Override
    public void addReceivingAddress(ReceivingAddress receivingAddress) {
        int count = receivingAddressCustomMapper.queryReceivingAddressCount(receivingAddress.getUserId(), ReceivingAddressStatus.EFFECTIVE.getCode());
        if(count >= 10){
            throw new ServiceException(ResultEnum.ADDRESS_COUNT_ERROR);
        }
        receivingAddress.setStatus(ReceivingAddressStatus.EFFECTIVE.getCode());
        receivingAddress.setGmtCreate(new Date());
        if(ReceivingAddressType.DEFAULT.getCode().intValue() == receivingAddress.getType().intValue()){
            receivingAddressCustomMapper.updateType2Common(receivingAddress.getUserId(),
                    ReceivingAddressType.COMMON.getCode(), ReceivingAddressType.DEFAULT.getCode());
        }
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

    @Override
    public ReceivingAddressDto getDefaultReceivingAddress(Integer userId) {
        return receivingAddressCustomMapper.queryByType(userId, ReceivingAddressType.DEFAULT.getCode(), ReceivingAddressStatus.EFFECTIVE.getCode());
    }
}
