package com.lylBlog.login.server.impl;

import com.lylBlog.common.util.DateUtil;
import com.lylBlog.common.util.EncryptionUtil;
import com.lylBlog.common.util.IdUtil;
import com.lylBlog.login.bean.UserBean;
import com.lylBlog.login.mapper.LoginMapper;
import com.lylBlog.login.server.LoginServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

@Service
public class LoginServerImpl implements LoginServer {

    @Resource
    private LoginMapper loginMapper;

    /**
     * 用户注册
     * @return
     */
    public int registerUser(UserBean userBean){
        UserBean user = loginMapper.findUserByEmail(userBean.getEmail());
        if(user != null){
            return 0;//该用户已注册
        }

        Map<String, String> map = EncryptionUtil.MD5Pwd(userBean.getEmail(),userBean.getPassword());
        userBean.setId(IdUtil.getGUID());
        userBean.setPassword(map.get("password"));
        userBean.setSalt(map.get("salt"));
        userBean.setRegtime(DateUtil.dateTimeToStr(new Date()));
        int result = loginMapper.registerUser(userBean);
        if(result > 0){
            userBean.setUserId(userBean.getId());//用户id
            userBean.setRoleId("w4lI24P684Gcp6Yx");//默认角色：普通用户
            userBean.setId(IdUtil.getGUID());
            loginMapper.addUserAndRoleRelevant(userBean);
            return 1;
        }else{
            return 2;
        }
    }

    /**
     * 通过邮箱查询用户是否存在
     * @param email
     * @return
     */
    public UserBean findUserByEmail(String email){
        UserBean user = loginMapper.findUserByEmail(email);
        if(user != null){
            user.setRoles(loginMapper.queryRoles(email));
            user.setPerms(loginMapper.queryPerms(email));
        }
        return user;
    }
}
