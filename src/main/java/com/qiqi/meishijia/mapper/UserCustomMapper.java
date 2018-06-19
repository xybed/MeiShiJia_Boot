package com.qiqi.meishijia.mapper;

import com.qiqi.meishijia.model.User;

public interface UserCustomMapper {
    Integer verifyRegister(String username);

    Integer verifyPassword(String username, String password);

    void updatePid(String username);

    User login(String username, String password);

    Integer updatePassword(String username, String password);

    String queryAvatar(int id);

    Integer updateAvatar(User user);
}