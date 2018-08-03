package com.qiqi.msjback.config;

import com.qiqi.msjmapper.entity.BackUser;
import com.qiqi.msjmapper.enums.LockedStatus;
import com.qiqi.msjmapper.mapper.BackUserCustomMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

public class MyShiroRealm extends AuthorizingRealm {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private BackUserCustomMapper backUserCustomMapper;

    /**
     * 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        BackUser user = backUserCustomMapper.queryByUsername(username);
        if(user == null){
            throw new AccountException("用户名不正确");
        }else if(user.getLocked().intValue() == LockedStatus.LOCKED.getCode().intValue()){
            throw new AccountException("账号已被锁定,请联系管理员！");
        }
        logger.info("成功进入");
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, user.getPassword(), getName());
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("user", user);
        return authenticationInfo;
    }

    /**
     * 授权用户权限
     * 授权的方法是在碰到<shiro:hasPermission name=''></shiro:hasPermission>标签的时候调用的,它会去检测shiro框架中的权限(这里的permissions)是否包含有该标签的name值,如果有,里面的内容显示,如果没有,里面的内容不予显示(这就完成了对于权限的认证.)
     * shiro的权限授权是通过继承AuthorizingRealm抽象类，重载doGetAuthorizationInfo();
     * 当访问到页面的时候，链接配置了相应的权限或者shiro标签才会执行此方法否则不会执行，所以如果只是简单的身份认证没有权限的控制的话，那么这个方法可以不进行实现，直接返回null即可。
     * 在这个方法中主要是使用类：SimpleAuthorizationInfo
     * 进行角色的添加和权限的添加。
     * authorizationInfo.addRole(role.getRole());
     * authorizationInfo.addStringPermission(p.getPermission());
     * 当然也可以添加set集合：roles是从数据库查询的当前用户的角色，stringPermissions是从数据库查询的当前用户对应的权限
     * authorizationInfo.setRoles(roles);
     * authorizationInfo.setStringPermissions(stringPermissions);
     * 就是说如果在shiro配置文件中添加了filterChainDefinitionMap.put(“/add”, “perms[权限添加]”);
     * 就说明访问/add这个链接必须要有“权限添加”这个权限才可以访问，
     * 如果在shiro配置文件中添加了filterChainDefinitionMap.put(“/add”, “roles[100002]，perms[权限添加]”);
     * 就说明访问/add这个链接必须要有“权限添加”这个权限和具有“100002”这个角色才可以访问。
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        return null;
    }
}
