package com.qiqi.msjback.service.impl;

import com.qiqi.msjback.common.Constants;
import com.qiqi.msjback.service.SessionService;
import com.qiqi.msjmapper.entity.BackUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements SessionService {
    @Override
    public BackUser getUser() {
        Session session = SecurityUtils.getSubject().getSession();
        return (BackUser) session.getAttribute(Constants.SESSION_USER);
    }
}
