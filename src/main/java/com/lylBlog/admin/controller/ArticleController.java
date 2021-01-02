package com.lylBlog.admin.controller;

import com.alibaba.fastjson.JSON;
import com.lylBlog.admin.bean.ArticleBean;
import com.lylBlog.admin.bean.LabelBean;
import com.lylBlog.admin.server.ArticleServer;
import com.lylBlog.common.bean.ResultObj;
import com.lylBlog.common.util.ShiroUtils;
import com.lylBlog.login.bean.UserBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleServer articleServer;

    private static String BASEPATH = "/admin/article";

    @RequestMapping("/articleList")
    public String articleList(Model model){
        return BASEPATH + "/articleList";
    }

    @RequestMapping("/releaseArticle")
    public String releaseArticle(Model model){
        return BASEPATH + "/releaseArticle";
    }

    @RequestMapping("/labelList")
    public String labelList(Model model){
        return BASEPATH + "/labelList";
    }

    @RequestMapping("/saveOrEditLabelData")
    public String saveOrEditLabelData(Model model){
        return BASEPATH + "/saveOrEditLabel";
    }

    @RequestMapping("/previewArticle/{wznm}")
    public String previewArtilce(Model model, @PathVariable String wznm){
        ArticleBean articleBean = new ArticleBean();
        articleBean.setWznm(wznm);
        ResultObj resultObj = articleServer.queryArticleInfo(articleBean);
        model.addAttribute("type","preview");
        System.out.println(resultObj.getData().get(0).toString());
        model.addAttribute("article", resultObj.getData().get(0));
        return "/blog/details";
    }

    /**
     * 查询文章列表信息
     * @param articleBean
     * @return
     */
    @RequestMapping("/queryArticleInfo")
    @ResponseBody
    public ResultObj queryArticleInfo(@RequestBody ArticleBean articleBean){
        try{
            return articleServer.queryArticleInfo(articleBean);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultObj.fail();
    }

    /**
     * 新增或修改文章信息
     * @param articleBean
     * @return
     */
    @RequestMapping("/addOrUpdaArticleInfo")
    @ResponseBody
    public ResultObj addOrUpdaArticleInfo(@RequestBody ArticleBean articleBean, String type){
        try{
            return articleServer.addOrUpdaArticleInfo(articleBean, type);
            //return ResultObj.ok();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultObj.fail();
    }

    /**
     * 删除文章信息
     * @param deleteIds
     * @return
     */
    @RequestMapping("/deleteArticleInfo")
    @ResponseBody
    public ResultObj deleteArticleInfo(@RequestBody List<String> deleteIds){
        try{
            return  articleServer.deleteArticleInfo(deleteIds);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultObj.fail();
    }

    /**
     * 查询标签信息
     * @param label
     * @return
     */
    @RequestMapping("/queryLabelInfo")
    @ResponseBody
    public ResultObj queryLabelInfo(@RequestBody LabelBean label){
        try{
            return articleServer.queryLabelInfo(label);
        }catch (Exception e){
           e.printStackTrace();
        }
        return ResultObj.fail();
    }

    /**
     * 新增或修改标签
     * @param label
     * @return
     */
    @RequestMapping("/addOrUpdaLabelInfo")
    @ResponseBody
    public ResultObj addOrUpdaLabelInfo(@RequestBody LabelBean label, String type){
        try{
            return articleServer.addOrUpdaLabelInfo(label, type);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultObj.fail();
    }

    /**
     * 删除标签
     * @param deleteIds
     * @return
     */
    @RequestMapping("/deleteLabelInfo")
    @ResponseBody
    public ResultObj deleteLabelInfo(@RequestBody List<String> deleteIds){
        try{
            return  articleServer.deleteLabelInfo(deleteIds);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultObj.fail();
    }
}
