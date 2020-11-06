package com.lylBlog.common.util;

import com.lylBlog.login.bean.UserBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionKey;

import java.io.Serializable;

/**
 * @Description Shiro工具类
 * @Author Sans
 * @CreateTime 2019/6/15 16:11
 */
public class ShiroUtils {

    /** 私有构造器 **/
    private ShiroUtils(){}

    //private static RedisSessionDAO redisSessionDAO = SpringUtil.getBean(RedisSessionDAO.class);

    /**
     * 获取当前用户Session
     * @Author Sans
     * @CreateTime 2019/6/17 17:03
     * @Return SysUserEntity 用户信息
     */
    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    /**
     * 通过sessionid获取Session
     * @param sessionId
     * @return Session
     */
    public static Session getSessionById(final String sessionId){
        SessionKey sessionKey = new SessionKey() {
            @Override
            public Serializable getSessionId() {
                return sessionId;
            }
        };
        return SecurityUtils.getSecurityManager().getSession(sessionKey);
    }

    /**
     * 获取当前用户信息
     * @return
     */
    public static UserBean getUserInfo(){
        return (UserBean) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 判断用户是否认证
     * @return
     */
    public static boolean isAuthenticated(){
       return SecurityUtils.getSubject().isAuthenticated();
    }

    /**
     * 判断用户是否拥有该权限
     * @param permission
     * @return
     */
    public static boolean isPermitted(String permission){return SecurityUtils.getSubject().isPermitted(permission);}

    /**
     * 用户登出
     * @Author Sans
     * @CreateTime 2019/6/17 17:23
     */
    public static void logout() {
        SecurityUtils.getSubject().logout();
    }
}
