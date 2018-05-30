package com.qiqi.meishijia.service.impl;

import com.qiqi.meishijia.dao.UserTokenMapper;
import com.qiqi.meishijia.model.UserToken;
import com.qiqi.meishijia.service.UserTokenService;
import com.qiqi.meishijia.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by 77 on 2018/05/30.
 */
@Service
@Transactional
public class UserTokenServiceImpl extends AbstractService<UserToken> implements UserTokenService {
    @Resource
    private UserTokenMapper userTokenMapper;

}
