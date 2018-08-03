package com.qiqi.msjapi.service.impl;

import com.qiqi.commonlib.common.Constants;
import com.qiqi.commonlib.lib.utils.DateUtil;
import com.qiqi.msjapi.utils.JWTUtil;
import com.qiqi.commonlib.common.ResultEnum;
import com.qiqi.commonlib.common.ServiceException;
import com.qiqi.msjmapper.enums.Sex;
import com.qiqi.msjmapper.mapper.UserCustomMapper;
import com.qiqi.msjmapper.mapper.UserMapper;
import com.qiqi.msjmapper.mapper.UserTokenCustomMapper;
import com.qiqi.msjmapper.entity.User;
import com.qiqi.msjmapper.entity.UserToken;
import com.qiqi.msjapi.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by 77 on 2018/05/25.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserCustomMapper userCustomMapper;
    @Resource
    private UserTokenCustomMapper userTokenCustomMapper;

    @Transactional
    @Override
    public Integer register(String username, String password, String verifyCode) {
        /*
        1.先检测此用户是否注册过
        2.若注册过，密码是否相同
        3.没有注册过就注册，设置默认信息
        4.设置消息主体id，3、4步骤要用到事务
         */
        Integer isRegister = userCustomMapper.verifyRegister(username);
        if(isRegister == 1){
            Integer passwordIsCorrect = userCustomMapper.verifyPassword(username, password);
            if(passwordIsCorrect == 1){
                return 1;
            }else {
                throw new ServiceException(ResultEnum.REGISTERED);
            }
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setVerifyCode(verifyCode);
        user.setRegisterDate(DateUtil.getTime("yyyy-MM-dd HH:mm:ss"));
        user.setAvatar(Constants.DEFAULT_AVATAR);
        //注册时，昵称用手机号代替
        user.setNickname(username);
        user.setMobilePhone(username);
        //性别为未知
        user.setSex(Sex.UNKNOW.ordinal());

        try {
            //注册用户
            //如果sql执行不成功，这一句便会抛异常，事务回滚
            userMapper.insertSelective(user);
            //设置pid
            userCustomMapper.updatePid(username);
            return 2;
        }catch (Exception e){
            throw new ServiceException(ResultEnum.REGISTER_FAIL);
        }
    }

    @Override
    public User login(String username, String password) {
        User user = userCustomMapper.login(username, password);
        if(user == null)
            throw new ServiceException(ResultEnum.LOGIN_ERROR);

        String token = JWTUtil.createNewToken(username);
        UserToken userToken = new UserToken();
        userToken.setUsername(username);
        userToken.setToken(token);
        Integer result = userTokenCustomMapper.insertOrUpdateToken(userToken);
        //插入影响行为1，更新影响行为2
        if(result != 1 && result != 2){
            throw new ServiceException(ResultEnum.LOGIN_FAIL);
        }

        user.setAvatar(Constants.URL_PREFIX+user.getAvatar());
        user.setToken(token);
        return user;
    }

    @Override
    public void logout(String token) {
        userTokenCustomMapper.logout(token);
    }

    @Override
    public void updatePassword(String username, String password) {
        Integer result = userCustomMapper.updatePassword(username, password);
        if(result != 1)
            throw new ServiceException(ResultEnum.MODIFY_FAIL);
    }

    @Override
    public void updateUser(User user) {
        String avatar = user.getAvatar();
        avatar = avatar.substring((Constants.URL_PREFIX).length(), avatar.length());
        user.setAvatar(avatar);
        Integer result = userMapper.updateByPrimaryKeySelective(user);
        if(result != 1)
            throw new ServiceException(ResultEnum.MODIFY_FAIL);
    }

}
