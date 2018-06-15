package com.qiqi.meishijia.mapper;

import com.qiqi.meishijia.model.UserToken;

public interface UserTokenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserToken record);

    int insertSelective(UserToken record);

    UserToken selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserToken record);

    int updateByPrimaryKey(UserToken record);
}