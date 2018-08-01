package com.qiqi.msjapi.service;

import com.qiqi.msjmapper.entity.RelationChain;
import com.qiqi.msjmapper.pojo.Contacts;
import com.qiqi.msjmapper.pojo.ContactsDetail;

import java.util.List;

public interface ImService {
    List<Contacts> getContacts(Integer userId);

    ContactsDetail getContactsDetail(Integer userId, Integer friendId);

    void modifyRemark(RelationChain relationChain);
}
