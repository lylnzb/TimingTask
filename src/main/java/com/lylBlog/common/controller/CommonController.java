package com.lylBlog.common.controller;

import com.baidu.ueditor.ActionEnter;
import com.lylBlog.common.bean.MenuBean;
import com.lylBlog.common.bean.ResultObj;
import com.lylBlog.common.server.CommonServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/common")
public class CommonController {

    @Resource
    private CommonServer commonServer;

    /**
     * 根据编码类别查询字典
     * @param dictType
     * @return
     */
    @RequestMapping(value="/queryCodeValue",method= RequestMethod.POST)
    @ResponseBody
    public ResultObj queryCodeValue(String dictType){
        try {
            return commonServer.queryCodeValue(dictType);
        } catch (Exception e){
            e.printStackTrace();
        }
        return ResultObj.fail();
    }

    /**
     * 查询音乐列表
     * @return
     */
    @RequestMapping(value="/queryMusicList")
    @ResponseBody
    public Object[][] queryMusicList(){
        try {
            return commonServer.queryMusicList();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 导航栏初始化
     * @return
     */
    @RequestMapping(value="/queryMeunInfo")
    @ResponseBody
    public ResultObj queryMeunInfo(){
        try {
            return commonServer.queryMeunInfo();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
