package com.lylBlog.admin.server.impl;

import com.lylBlog.admin.bean.UserOnlineBean;
import com.lylBlog.admin.mapper.UserOnlineMapper;
import com.lylBlog.admin.server.UserOnlineServer;
import com.lylBlog.common.session.OnlineSessionDAO;
import com.lylBlog.common.util.DateUtil;
import com.lylBlog.common.util.StringUtil;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: lyl
 * @Date: 2021/2/4 20:27
 */
@Service
public class UserOnlineServerImpl implements UserOnlineServer {

    @Autowired
    private UserOnlineMapper userOnlineDao;

    /**
     * 通过会话序号查询信息
     *
     * @param sessionId 会话ID
     * @return 在线用户信息
     */
    @Override
    public UserOnlineBean selectOnlineById(String sessionId)
    {
        return userOnlineDao.selectOnlineById(sessionId);
    }

    /**
     * 通过会话序号删除信息
     *
     * @param sessionId 会话ID
     * @return 在线用户信息
     */
    @Override
    public void deleteOnlineById(String sessionId)
    {
        UserOnlineBean userOnline = selectOnlineById(sessionId);
        if (StringUtil.isNotNull(userOnline))
        {
            userOnlineDao.deleteOnlineById(sessionId);
        }
    }

    /**
     * 通过会话序号删除信息
     *
     * @param sessions 会话ID集合
     * @return 在线用户信息
     */
    @Override
    public void batchDeleteOnline(List<String> sessions)
    {
        for (String sessionId : sessions)
        {
            UserOnlineBean userOnline = selectOnlineById(sessionId);
            if (StringUtil.isNotNull(userOnline))
            {
                userOnlineDao.deleteOnlineById(sessionId);
            }
        }
    }

    /**
     * 保存会话信息
     *
     * @param online 会话信息
     */
    @Override
    public void saveOnline(UserOnlineBean online)
    {
        userOnlineDao.saveOnline(online);
    }

    /**
     * 查询会话集合
     *
     */
    @Override
    public List<UserOnlineBean> selectUserOnlineList(UserOnlineBean userOnline)
    {
        return userOnlineDao.selectUserOnlineList(userOnline);
    }

    /**
     * 强退用户
     *
     * @param sessionId 会话ID
     */
    @Override
    public void forceLogout(String sessionId)
    {

    }

    /**
     * 查询会话集合
     *
     */
    @Override
    public List<UserOnlineBean> selectOnlineByExpired(Date expiredDate)
    {
        String lastAccessTime = DateUtil.datetimeToStr(expiredDate, "yyyy-MM-dd hh:mm:ss");
        return userOnlineDao.selectOnlineByExpired(lastAccessTime);
    }
}
