package com.lylBlog.index.controller;

import com.lylBlog.admin.bean.BlogSetBean;
import com.lylBlog.common.bean.ResultObj;
import com.lylBlog.common.util.ShiroUtils;
import com.lylBlog.index.bean.ArticleListBean;
import com.lylBlog.index.mapper.IndexMapper;
import com.lylBlog.index.server.IndexServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @Resource
    private IndexServer indexServer;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/about/aboutMe")
    public String aboutMe(){
        return "/about/aboutMe";
    }

    @RequestMapping("/showCardInfo")
    @ResponseBody
    public ResultObj showCardInfo(String articleType){
        try{
            return  indexServer.showCardInfo(articleType);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultObj.fail();
    }

    /**
     * 展示网站首页最新文章列表信息
     * @return
     */
    @RequestMapping("/showArticleInfo")
    @ResponseBody
    public ResultObj showArticleInfo(){
        try{
            return indexServer.showArticleInfo();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultObj.fail();
    }
}
