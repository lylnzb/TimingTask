package com.lylBlog.admin.controller;

import com.lylBlog.admin.bean.DictDataBean;
import com.lylBlog.admin.bean.DictTypeBean;
import com.lylBlog.admin.server.DictServer;
import com.lylBlog.common.bean.ResultObj;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/dict")
public class DictController {

    @Resource
    private DictServer dictServer;

    private static String BASEPATH = "admin/dict";

    @RequestMapping("/queryDictTypeInfo")
    @ResponseBody
    public ResultObj queryDictTypeInfo(@RequestBody DictTypeBean dictTypeBean){
        try{
            return dictServer.queryDictTypeInfo(dictTypeBean);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/addOrEditDictTypeInfo")
    @ResponseBody
    public ResultObj addOrEditDictTypeInfo(@RequestBody DictTypeBean dictTypeBean,String type){
        try{
            return dictServer.addOrEditDictTypeInfo(dictTypeBean, type);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/deleteDictTypeInfo")
    @ResponseBody
    public ResultObj deleteDictTypeInfo(@RequestBody DictTypeBean dictTypeBean){
        try{
            return dictServer.deleteDictTypeInfo(dictTypeBean);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/addOrEditDictDataInfo")
    @ResponseBody
    public ResultObj addOrEditDictDataInfo(@RequestBody DictDataBean dictDataBean, String type){
        try{
            return dictServer.addOrEditDictDataInfo(dictDataBean, type);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/queryDictDataInfo")
    @ResponseBody
    public ResultObj queryDictDataInfo(@RequestBody DictDataBean dictDataBean){
        try{
            return dictServer.queryDictDataInfo(dictDataBean);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/deleteDictDataInfo")
    @ResponseBody
    public ResultObj deleteDictDataInfo(@RequestBody DictDataBean dictDataBean){
        try{
            return dictServer.deleteDictDataInfo(dictDataBean);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/dictData")
    public String dictData(Model model){
        return BASEPATH + "/dictData";
    }

    @RequestMapping("/saveOrEditDictData")
    public String saveOrEditDictData(Model model){
        return BASEPATH + "/saveOrEditDictData";
    }

    @RequestMapping("/saveOrEditDictType")
    public String saveOrEditDictType(Model model){
        return BASEPATH + "/saveOrEditDictType";
    }
}
