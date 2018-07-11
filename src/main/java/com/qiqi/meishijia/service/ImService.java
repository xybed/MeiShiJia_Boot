package com.qiqi.meishijia.service;

import com.qiqi.meishijia.pojo.Contacts;

import java.util.List;

public interface ImService {
    List<Contacts> getContacts(Integer userId);
}
