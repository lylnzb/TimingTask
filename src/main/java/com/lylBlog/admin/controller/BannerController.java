package com.lylBlog.admin.controller;

import com.lylBlog.admin.bean.BannerBean;
import com.lylBlog.admin.server.BannerServer;
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

    @RequestMapping("/addOrUpdaBanner")
    public String addOrUpdaBanner(Model model){
        return BASEPATH + "/addOrUpdaBanner";
    }

    /**
     * 查询所有轮播图信息
     * @param bannerBean
     * @return
     */
    @RequestMapping("/queryBannerInfo")
    @ResponseBody
    public ResultObj queryBannerInfo(@RequestBody BannerBean bannerBean){
        try{
            return bannerServer.queryBannerInfo(bannerBean);
        }catch(Exception e){
            e.printStackTrace();
        }
        return ResultObj.fail();
    }

    /**
     * 新增轮播图信息
     * @param bannerBean
     * @return
     */
    @RequestMapping("/addOrUpdaBannerInfo")
    @ResponseBody
    public ResultObj addOrUpdaBannerInfo(@RequestBody BannerBean bannerBean, String type){
        try{
            return bannerServer.addOrUpdaBannerInfo(bannerBean, type);
        }catch(Exception e){
            e.printStackTrace();
        }
        return ResultObj.fail();
    }

    /**
     * 删除轮播图信息
     * @param deleteIds
     * @return
     */
    @RequestMapping("/deleteBannerInfo")
    @ResponseBody
    public ResultObj deleteBannerInfo(@RequestBody List<String> deleteIds){
        try{
            return bannerServer.deleteBannerInfo(deleteIds);
        }catch(Exception e){
            e.printStackTrace();
        }
        return ResultObj.fail();
    }
}
