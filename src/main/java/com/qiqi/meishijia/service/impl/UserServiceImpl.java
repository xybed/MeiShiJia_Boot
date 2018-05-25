package com.qiqi.meishijia.service.impl;

import com.qiqi.meishijia.dao.UserMapper;
import com.qiqi.meishijia.model.User;
import com.qiqi.meishijia.service.UserService;
import com.qiqi.meishijia.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by 77 on 2018/05/25.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

}
