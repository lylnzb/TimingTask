package com.lylBlog.admin.server.impl;

import com.lylBlog.admin.mapper.ArticleMapper;
import com.lylBlog.admin.server.ArticleServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ArticleServerImpl implements ArticleServer {

    @Resource
    private ArticleMapper articleMapper;


}
