package com.lylBlog.login.server;

import com.lylBlog.login.bean.UserBean;

public interface LoginServer {

    /**
     * 用户注册
     * @return
     */
    public int registerUser(UserBean userBean);

    /**
     * 通过邮箱查询用户是否存在
     * @param email
     * @return
     */
    public UserBean findUserByEmail(String email);
}
