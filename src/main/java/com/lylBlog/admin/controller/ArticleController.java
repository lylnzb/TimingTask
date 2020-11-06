package com.lylBlog.admin.controller;

import com.lylBlog.admin.server.ArticleServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleServer articleServer;


}
