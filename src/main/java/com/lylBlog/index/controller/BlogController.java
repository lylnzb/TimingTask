package com.lylBlog.index.controller;

import com.lylBlog.admin.bean.ArticleBean;
import com.lylBlog.admin.server.ArticleServer;
import com.lylBlog.common.bean.ResultObj;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @Author: lyl
 * @Date: 2020/11/14 15:54
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

    @Resource
    private ArticleServer articleServer;

    @RequestMapping("/blogList")
    public String blogList(){
        return "/blog/blogList";
    }

    @RequestMapping("/detail/{wznm}")
    public String previewArtilce(Model model, @PathVariable String wznm){
        ArticleBean articleBean = new ArticleBean();
        articleBean.setWznm(wznm);
        ResultObj resultObj = articleServer.queryArticleInfo(articleBean);
        model.addAttribute("type","preview");
        System.out.println(resultObj.getData().get(0).toString());
        model.addAttribute("article", resultObj.getData().get(0));
        return "/blog/details";
    }
}
