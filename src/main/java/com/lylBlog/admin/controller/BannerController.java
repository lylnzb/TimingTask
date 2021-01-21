package com.lylBlog.admin.controller;

import com.lylBlog.admin.server.BannerServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @Author: lyl
 * @Date: 2021/1/20 19:33
 */
@Controller
@RequestMapping("/banner")
public class BannerController {

    @Resource
    private BannerServer bannerServer;

    private static String BASEPATH = "/admin/banner";

    @RequestMapping("/bannerData")
    public String articleList(Model model){
        return BASEPATH + "/bannerList";
    }
}
