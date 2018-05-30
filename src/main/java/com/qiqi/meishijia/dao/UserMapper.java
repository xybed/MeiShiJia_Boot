package com.qiqi.meishijia.dao;

import com.qiqi.meishijia.core.Mapper;
import com.qiqi.meishijia.model.User;
import com.qiqi.meishijia.model.UserToken;

public interface UserMapper extends Mapper<User> {
    Integer verifyRegister(String username);
    Integer verifyPassword(String username, String password);
    Integer register(User user);
    Integer updatePid(String username);
    User login(String username, String password);
    Integer insertOrUpdateToken(UserToken userToken);
    Integer logout(String token);
    Integer updatePassword(String username, String password);
    Integer updateUser(User user);
    String queryAvatar(int id);
    Integer updateAvatar(User user);
}