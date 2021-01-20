package com.lylBlog.admin.server.impl;

import com.lylBlog.admin.mapper.BannerMapper;
import com.lylBlog.admin.server.BannerServer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Author: lyl
 * @Date: 2021/1/20 19:30
 */
@Service
public class BannerServerImpl implements BannerServer {

    @Resource
    private BannerMapper bannerMapper;


}
