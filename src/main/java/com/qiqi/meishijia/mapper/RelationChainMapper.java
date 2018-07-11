package com.qiqi.meishijia.mapper;

import com.qiqi.meishijia.model.RelationChain;
import com.qiqi.meishijia.pojo.Contacts;

import java.util.List;

public interface RelationChainMapper {
    int insert(RelationChain record);

    int insertSelective(RelationChain record);

    List<Contacts> selectRelationChainByUserId(Integer userId);
}