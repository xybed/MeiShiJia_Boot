package com.qiqi.meishijia.mapper;

import com.qiqi.meishijia.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserCustomMapper {
    Integer verifyRegister(String username);

    Integer verifyPassword(@Param("username") String username, @Param("password") String password);

    void updatePid(String username);

    User login(@Param("username") String username, @Param("password") String password);

    Integer updatePassword(@Param("username") String username, @Param("password") String password);

    String queryAvatar(int id);

    Integer updateAvatar(User user);
}