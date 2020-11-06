package com.lylBlog.common.config;

import com.lylBlog.admin.bean.PermissionBean;
import com.lylBlog.admin.bean.RoleBean;
import com.lylBlog.common.util.ShiroUtils;
import com.lylBlog.login.bean.UserBean;
import com.lylBlog.login.server.LoginServer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * 描述：
 *
 * @author caojing
 * @create 2019-01-27-13:57
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private LoginServer loginServer;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取当前用户信息

        UserBean user = loginServer.findUserByEmail(ShiroUtils.getUserInfo().getEmail());
        for(RoleBean role : user.getRoles()){
            info.addRole(role.getRolename());
        }
        for(PermissionBean perm : user.getPerms()){
            info.addStringPermission(perm.getPermission());
        }
        return info;
    }

    /**
     * 获取即将需要认证的信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("-------身份认证方法--------");
        String userName = (String) authenticationToken.getPrincipal();
        String userPwd = new String((char[]) authenticationToken.getCredentials());
        //根据用户名从数据库获取密码
        UserBean user = loginServer.findUserByEmail(userName);
        if (user == null) {
            throw new AccountException("找不到该用户信息");
        }
        String md5Pwd = new SimpleHash("MD5", userPwd,
                ByteSource.Util.bytes(user.getEmail() + ((user.getSalt() == null)?"":user.getSalt())), 2).toHex();
        if (user.getPassword() == null) {
            throw new AccountException("用户名不正确");
        } else if (!md5Pwd.equals(user.getPassword())) {
            throw new AccountException("密码不正确");
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(),
                ByteSource.Util.bytes(userName + user.getSalt()), getName());
    }
}