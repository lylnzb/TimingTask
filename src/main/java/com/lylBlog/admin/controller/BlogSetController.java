package com.lylBlog.admin.controller;

import com.lylBlog.admin.bean.BlogSetBean;
import com.lylBlog.admin.server.BlogSetServer;
import com.lylBlog.common.bean.ResultObj;
import com.lylBlog.common.util.ShiroUtils;
import com.lylBlog.login.bean.UserBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 博客设置控制层
 * @Author: lyl
 * @Date: 2021/1/3 10:32
 */
@Controller
@RequestMapping("/blogSet")
public class BlogSetController {

    @Resource
    private BlogSetServer blogSetServer;

    @RequestMapping("/blogSetData")
    public String blogSetData(){
        return "/admin/blogSet/blogData";
    }

    /**
     * 查看博客设置
     * @return
     */
    @RequestMapping("/viewBlogSetInfo")
    @ResponseBody
    public ResultObj viewBlogSetInfo(){
        try{
            return blogSetServer.viewBlogSetInfo();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultObj.fail();
    }

    /**
     * 配置博客设置
     * @return
     */
    @RequestMapping("/configurationBlogSetInfo")
    @ResponseBody
    public ResultObj configurationBlogSetInfo(@RequestBody BlogSetBean blogSet){
        try{
            return blogSetServer.configurationBlogSetInfo(blogSet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultObj.fail();
    }
}
