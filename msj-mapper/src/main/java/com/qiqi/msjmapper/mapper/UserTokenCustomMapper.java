package com.qiqi.msjmapper.mapper;

import com.qiqi.msjmapper.entity.UserToken;

public interface UserTokenCustomMapper {
    String queryToken(String username);

    Integer insertOrUpdateToken(UserToken userToken);

    void logout(String token);
}
