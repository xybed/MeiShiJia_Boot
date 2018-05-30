package com.qiqi.meishijia.service.impl;

import com.qiqi.meishijia.core.ServiceException;
import com.qiqi.meishijia.dao.UserMapper;
import com.qiqi.meishijia.model.User;
import com.qiqi.meishijia.model.UserToken;
import com.qiqi.meishijia.service.UserService;
import com.qiqi.meishijia.core.AbstractService;
import lib.utils.DateUtil;
import lib.utils.MD5Util;
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

    @Override
    public Integer register(String username, String password, String verifyCode) {
        /*
        1.先检测此用户是否注册过
        2.若注册过，密码是否相同
        3.没有注册过就注册，设置默认信息
        4.设置消息主体id，3、4步骤要用到事务
         */
        Integer isRegister = userMapper.verifyRegister(username);
        if(isRegister == 1){
            Integer passwordIsCorrect = userMapper.verifyPassword(username, password);
            if(passwordIsCorrect == 1){
                return 1;
            }else {
                throw new ServiceException("该用户已注册过");
            }
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setVerifyCode(verifyCode);
        user.setRegisterDate(DateUtil.getTime("yyyy-MM-dd HH:mm:ss"));
        user.setAvatar("avatar/icon_default_avatar.png");
        //注册时，昵称用手机号代替
        user.setNickname(username);
        user.setMobilePhone(username);
        //性别为未知
        user.setSex(0);

        try {
            //注册用户
            Integer affectedCount1 = userMapper.register(user);
            //如果sql执行不成功，affectedCount1则会为0，这一句便会抛异常，事务回滚
            int i = 1 / affectedCount1;
            //设置pid
            int affectedCount2 = userMapper.updatePid(username);
            i = 1 / affectedCount2;
            return 2;
        }catch (Exception e){
            throw new ServiceException("注册失败，请稍后再试");
        }
    }

    @Override
    public User login(String username, String password) {
        User user = userMapper.login(username, password);
        if(user == null)
            throw new ServiceException("用户名或密码不正确");

        long time = System.currentTimeMillis();
        String token = MD5Util.MD5(username + time);
        long deadline = time + 7 * 24 * 60 * 60 * 1000;
        UserToken userToken = new UserToken();
        userToken.setUsername(username);
        userToken.setToken(token);
        userToken.setDeadline(deadline+"");
        Integer result = userMapper.insertOrUpdateToken(userToken);
        if(result != 1){
            throw new ServiceException("登录失败，请稍候再试");
        }

        //TODO 添加头像绝对路径
        user.setToken(token);
        return user;
    }
}
