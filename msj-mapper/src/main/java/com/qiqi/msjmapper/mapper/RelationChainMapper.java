package com.qiqi.msjmapper.mapper;

import com.qiqi.msjmapper.entity.RelationChain;
import com.qiqi.msjmapper.pojo.Contacts;
import com.qiqi.msjmapper.pojo.ContactsDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RelationChainMapper {
    int insert(RelationChain record);

    int insertSelective(RelationChain record);

    List<Contacts> selectRelationChainByUserId(Integer userId);

    ContactsDetail selectFriendInfoByUserId(@Param("userId") Integer userId, @Param("friendId") Integer friendId);

    int updateRemark(RelationChain record);
}