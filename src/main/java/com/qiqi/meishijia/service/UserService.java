package com.qiqi.meishijia.service;
import com.qiqi.meishijia.model.User;
import com.qiqi.meishijia.core.Service;


/**
 * Created by 77 on 2018/05/25.
 */
public interface UserService extends Service<User> {
    Integer register(String username, String password, String verifyCode);
    User login(String username, String password);
    void logout(String token);
    void updatePassword(String username, String password);
    void updateUser(User user);
    String queryAvatar(int id);
    void updateAvatar(int id, String avatar);
}
