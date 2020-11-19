package com.lylBlog.index.controller;

import com.lylBlog.common.util.ShiroUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/about/aboutMe")
    public String aboutMe(){
        return "/about/aboutMe";
    }
}
