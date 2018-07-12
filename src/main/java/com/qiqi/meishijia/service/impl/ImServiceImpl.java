package com.qiqi.meishijia.service.impl;

import com.qiqi.meishijia.common.Constants;
import com.qiqi.meishijia.mapper.RelationChainMapper;
import com.qiqi.meishijia.pojo.Contacts;
import com.qiqi.meishijia.pojo.ContactsDetail;
import com.qiqi.meishijia.service.ImService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ImServiceImpl implements ImService {

    @Resource
    private RelationChainMapper relationChainMapper;

    @Override
    public List<Contacts> getContacts(Integer userId) {
        List<Contacts> contactsList = relationChainMapper.selectRelationChainByUserId(userId);
        for(Contacts contacts : contactsList){
            contacts.setAvatar(Constants.URL_PREFIX + contacts.getAvatar());
        }
        return contactsList;
    }

    @Override
    public ContactsDetail getContactsDetail(Integer userId, Integer friendId) {
        ContactsDetail contactsDetail = relationChainMapper.selectFriendInfoByUserId(userId, friendId);
        contactsDetail.setAvatar(Constants.URL_PREFIX + contactsDetail.getAvatar());
        return contactsDetail;
    }
}
