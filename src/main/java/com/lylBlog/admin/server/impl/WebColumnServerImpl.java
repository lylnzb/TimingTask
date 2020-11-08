package com.lylBlog.admin.server.impl;

import com.lylBlog.admin.mapper.WebColumnMapper;
import com.lylBlog.admin.server.WebColumnServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: lyl
 * @Date: 2020/11/8 14:58
 */
@Service
public class WebColumnServerImpl implements WebColumnServer {

    @Resource
    private WebColumnMapper webColumnMapper;

}
