package com.lylBlog.admin.controller;

import com.lylBlog.admin.server.WebColumnServer;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @Author: lyl
 * @Date: 2020/11/8 15:00
 */
@Controller
public class WebColumnController {

    @Resource
    private WebColumnServer webColumnServer;

}
