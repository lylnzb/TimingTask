package com.lylBlog.admin.controller;

import com.lylBlog.admin.bean.WebColumnBean;
import com.lylBlog.admin.server.WebColumnServer;
import com.lylBlog.common.bean.ResultObj;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: lyl
 * @Date: 2020/11/8 15:00
 */
@Controller
@RequestMapping("/webColumn")
public class WebColumnController {

    @Resource
    private WebColumnServer webColumnServer;

    /**
     * 添加或编辑网站栏目信息
     * @param webColumnBean
     * @return
     */
    @RequiresPermissions("system:WebColumn:add")
    @RequestMapping("/addOrUpdateWebColumnInfo")
    @ResponseBody
    public ResultObj addOrUpdateWebColumnInfo(@RequestBody WebColumnBean webColumnBean, String type){
        try {
            return webColumnServer.addOrUpdateWebColumnInfo(webColumnBean, type);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultObj.fail();
    }

    /**
     * 查询网站栏目信息
     * @return
     */
    @RequiresPermissions("system:WebColumn:list")
    @RequestMapping("/queryWebColumnInfo")
    @ResponseBody
    public ResultObj queryWebColumnInfo(){
        try {
            return webColumnServer.queryWebColumnInfo();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultObj.fail();
    }

    /**
     * 根据id查询网站栏目信息
     * @param columnId
     * @return
     */
    @RequestMapping("/queryWebColumnInfoById")
    @ResponseBody
    public ResultObj queryWebColumnInfoById(String columnId){
        try {
            return webColumnServer.queryWebColumnInfoById(columnId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultObj.fail();
    }

    /**
     * 删除网站栏目信息
     * @param deleteIds
     * @return
     */
    @RequiresPermissions("system:WebColumn:delete")
    @RequestMapping("/deleteWebColumnInfo")
    @ResponseBody
    public ResultObj deleteWebColumnInfo(@RequestBody List<String> deleteIds){
        try {
            return webColumnServer.deleteWebColumnInfo(deleteIds);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultObj.fail();
    }

    /**
     * 查询所有父栏目信息
     * @return
     */
    @RequestMapping("/queryParentColumn")
    @ResponseBody
    public ResultObj queryParentColumn(){
        try {
            return webColumnServer.queryParentColumn();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultObj.fail();
    }
}
