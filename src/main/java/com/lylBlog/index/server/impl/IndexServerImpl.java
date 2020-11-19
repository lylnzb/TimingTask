package com.lylBlog.index.server.impl;

import com.lylBlog.index.mapper.IndexMapper;
import com.lylBlog.index.server.IndexServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: lyl
 * @Date: 2020/11/14 14:59
 */
@Service
public class IndexServerImpl implements IndexServer {

    @Resource
    private IndexMapper indexMapper;


}
