package com.qiqi.meishijia.mapper;

import com.qiqi.meishijia.model.UserToken;

public interface UserTokenCustomMapper {
    String queryToken(String username);

    Integer insertOrUpdateToken(UserToken userToken);

    void logout(String token);
}
