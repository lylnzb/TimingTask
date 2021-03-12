package com.lylBlog.common.listener;
import com.lylBlog.common.util.ShiroUtils;
import com.lylBlog.login.bean.UserBean;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

import javax.servlet.http.Cookie;

/**
 * 配置session监听器
 *
 * @author zhuyongsheng
 * @date 2019/8/12
 */
public class ShiroSessionListener implements SessionListener {

    /**
     * 回话创建触发
     *
     * @author zhuyongsheng
     * @date 2019/8/12
     */
    @Override
    public void onStart(Session session) {
        System.out.println("onStart====="+session);
        //获取当前用户信息
        UserBean userBean = ShiroUtils.getUserInfo();

    }

    /**
     * 退出会话时触发
     *
     * @author zhuyongsheng
     * @date 2019/8/12
     */
    @Override
    public void onStop(Session session) {
        System.out.println("onStop====="+session);
    }

    /**
     * 会话过期时触发
     *
     * @author zhuyongsheng
     * @date 2019/8/12
     */
    @Override
    public void onExpiration(Session session) {
        System.out.println("onExpiration====="+session);
    }
}
