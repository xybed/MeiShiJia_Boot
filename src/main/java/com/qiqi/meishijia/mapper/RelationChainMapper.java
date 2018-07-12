package com.qiqi.meishijia.mapper;

import com.qiqi.meishijia.model.RelationChain;
import com.qiqi.meishijia.pojo.Contacts;
import com.qiqi.meishijia.pojo.ContactsDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RelationChainMapper {
    int insert(RelationChain record);

    int insertSelective(RelationChain record);

    List<Contacts> selectRelationChainByUserId(Integer userId);

    ContactsDetail selectFriendInfoByUserId(@Param("userId") Integer userId, @Param("friendId") Integer friendId);

    int updateRemark(RelationChain record);
}