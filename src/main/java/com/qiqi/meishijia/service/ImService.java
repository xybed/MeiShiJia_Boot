package com.qiqi.meishijia.service;

import com.qiqi.meishijia.pojo.Contacts;
import com.qiqi.meishijia.pojo.ContactsDetail;

import java.util.List;

public interface ImService {
    List<Contacts> getContacts(Integer userId);

    ContactsDetail getContactsDetail(Integer userId, Integer friendId);
}
