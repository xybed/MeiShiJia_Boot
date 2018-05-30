package com.qiqi.meishijia.service;
import com.qiqi.meishijia.model.User;
import com.qiqi.meishijia.core.Service;


/**
 * Created by 77 on 2018/05/25.
 */
public interface UserService extends Service<User> {
    Integer register(String username, String password, String verifyCode);
    User login(String username, String password);
}
