package com.qiqi.meishijia.model;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class User {
    /**
     * 用户的唯一id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名，这里指定为手机号或是第三方登录的id
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 注册的验证码
     */
    @Column(name = "verify_code")
    @JSONField(name = "verify_code")
    private String verifyCode;

    /**
     * 注册的时间
     */
    @Column(name = "register_date")
    @JSONField(name = "register_date", format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String registerDate;

    private String avatar;

    /**
     * 真实姓名
     */
    @Column(name = "real_name")
    @JSONField(name = "real_name")
    private String realName;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 用户绑定的手机号，或者为手机注册时的手机号
     */
    @Column(name = "mobile_phone")
    @JSONField(name = "mobile_phone")
    private String mobilePhone;

    /**
     * 性别：0-保密，1-男，2-女
     */
    private Integer sex;

    private String birthday;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 所在省份
     */
    private String province;

    /**
     * 所在城市
     */
    private String city;

    /**
     * 地址
     */
    private String address;

    /**
     * 个性签名
     */
    private String signature;

    /**
     * 消息主体id
     */
    @Column(name = "principal_id")
    @JSONField(name = "principal_id")
    private Integer principalId;

    /**
     * 获取用户的唯一id
     *
     * @return id - 用户的唯一id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户的唯一id
     *
     * @param id 用户的唯一id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名，这里指定为手机号或是第三方登录的id
     *
     * @return username - 用户名，这里指定为手机号或是第三方登录的id
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名，这里指定为手机号或是第三方登录的id
     *
     * @param username 用户名，这里指定为手机号或是第三方登录的id
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取注册的验证码
     *
     * @return verify_code - 注册的验证码
     */
    public String getVerifyCode() {
        return verifyCode;
    }

    /**
     * 设置注册的验证码
     *
     * @param verifyCode 注册的验证码
     */
    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    /**
     * 获取注册的时间
     *
     * @return register_date - 注册的时间
     */
    public String getRegisterDate() {
        return registerDate;
    }

    /**
     * 设置注册的时间
     *
     * @param registerDate 注册的时间
     */
    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * @return avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param avatar
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取真实姓名
     *
     * @return real_name - 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实姓名
     *
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取昵称
     *
     * @return nickname - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取用户绑定的手机号，或者为手机注册时的手机号
     *
     * @return mobile_phone - 用户绑定的手机号，或者为手机注册时的手机号
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * 设置用户绑定的手机号，或者为手机注册时的手机号
     *
     * @param mobilePhone 用户绑定的手机号，或者为手机注册时的手机号
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * 获取性别：0-保密，1-男，2-女
     *
     * @return sex - 性别：0-保密，1-男，2-女
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别：0-保密，1-男，2-女
     *
     * @param sex 性别：0-保密，1-男，2-女
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * @return birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取所在省份
     *
     * @return province - 所在省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置所在省份
     *
     * @param province 所在省份
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取所在城市
     *
     * @return city - 所在城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置所在城市
     *
     * @param city 所在城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取个性签名
     *
     * @return signature - 个性签名
     */
    public String getSignature() {
        return signature;
    }

    /**
     * 设置个性签名
     *
     * @param signature 个性签名
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * 获取消息主体id
     *
     * @return principal_id - 消息主体id
     */
    public Integer getPrincipalId() {
        return principalId;
    }

    /**
     * 设置消息主体id
     *
     * @param principalId 消息主体id
     */
    public void setPrincipalId(Integer principalId) {
        this.principalId = principalId;
    }
}