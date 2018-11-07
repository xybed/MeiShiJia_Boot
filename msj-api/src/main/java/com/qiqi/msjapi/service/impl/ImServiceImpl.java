package com.qiqi.msjapi.service.impl;

import com.qiqi.commonconfig.common.Constants;
import com.qiqi.msjmapper.mapper.RelationChainMapper;
import com.qiqi.msjmapper.entity.RelationChain;
import com.qiqi.msjmapper.pojo.Contacts;
import com.qiqi.msjmapper.pojo.ContactsDetail;
import com.qiqi.msjapi.service.ImService;
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

    @Override
    public void modifyRemark(RelationChain relationChain) {
        relationChainMapper.updateRemark(relationChain);
    }
}
