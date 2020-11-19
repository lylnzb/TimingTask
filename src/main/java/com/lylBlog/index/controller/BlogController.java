package com.lylBlog.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: lyl
 * @Date: 2020/11/14 15:54
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

    @RequestMapping("/blogList")
    public String blogList(){
        return "/blog/blogList";
    }
}
