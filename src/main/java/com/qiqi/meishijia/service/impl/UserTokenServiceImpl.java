package com.qiqi.meishijia.service.impl;

import com.qiqi.meishijia.mapper.UserTokenCustomMapper;
import com.qiqi.meishijia.service.UserTokenService;
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
