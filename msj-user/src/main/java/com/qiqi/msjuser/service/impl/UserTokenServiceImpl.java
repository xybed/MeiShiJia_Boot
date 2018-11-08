package com.qiqi.msjuser.service.impl;

import com.qiqi.msjmapper.mapper.UserTokenCustomMapper;
import com.qiqi.msjuser.service.UserTokenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userTokenService")
public class UserTokenServiceImpl implements UserTokenService {

    @Resource
    private UserTokenCustomMapper userTokenCustomMapper;

    @Override
    public String queryToken(String username) {
        return userTokenCustomMapper.queryToken(username);
    }
}
