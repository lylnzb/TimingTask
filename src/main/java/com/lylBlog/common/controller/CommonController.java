package com.lylBlog.common.controller;

import com.lylBlog.common.bean.ResultObj;
import com.lylBlog.common.server.CommonServer;
import com.lylBlog.common.util.file.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

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
}
