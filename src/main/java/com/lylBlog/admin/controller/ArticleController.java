package com.lylBlog.admin.controller;

import com.lylBlog.admin.bean.LabelBean;
import com.lylBlog.admin.server.ArticleServer;
import com.lylBlog.common.bean.ResultObj;
import com.lylBlog.common.util.ShiroUtils;
import com.lylBlog.login.bean.UserBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
