package com.qiqi.msjapi.service;

import com.qiqi.msjmapper.entity.User;


/**
 * Created by 77 on 2018/05/25.
 */
public interface UserService {
    Integer register(String username, String password, String verifyCode);

    User login(String username, String password);

    void logout(String token);

    void updatePassword(String username, String password);

    void updateUser(User user);
}
