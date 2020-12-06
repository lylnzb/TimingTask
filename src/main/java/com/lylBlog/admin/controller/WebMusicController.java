package com.lylBlog.admin.controller;

import com.lylBlog.admin.bean.WebMusicBean;
import com.lylBlog.admin.server.WebMusicServer;
import com.lylBlog.common.bean.ResultObj;
import com.lylBlog.common.config.LylBlogConfig;
import com.lylBlog.common.util.IdUtil;
import com.lylBlog.common.util.file.FileDownloadUtil;
import com.lylBlog.common.util.file.FileUploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: lyl
 * @Date: 2020/11/15 13:29
 */
@Controller
@RequestMapping("/webMusic")
public class WebMusicController {

    private static String BASEPATH = "/admin/music";

    @Resource
    private WebMusicServer webMusicServer;

    @RequestMapping("/musicData")
    public String musicData(){
        return BASEPATH + "/musicData";
    }

    @RequestMapping("/addOrUpdaMusic")
    public String addOrUpdaMusic(){
        return BASEPATH + "/addOrUpdaMusic";
    }

    /**
     * 查询所有音乐信息
     * @param webMusicBean
     * @return
     */
    @RequestMapping("/queryMusicInfo")
    @ResponseBody
    public ResultObj queryMusicInfo(@RequestBody WebMusicBean webMusicBean){
        try{
            return webMusicServer.queryMusicInfo(webMusicBean);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultObj.fail();
    }

    /**
     * 添加或编辑网站音乐信息
     * @param webMusicBean
     * @return
     */
    @RequestMapping("/addOrUpdateMusicInfo")
    @ResponseBody
    public ResultObj addOrUpdateMusicInfo(@RequestBody WebMusicBean webMusicBean, String type){
        try{
            return webMusicServer.addOrUpdateMusicInfo(webMusicBean, type);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultObj.fail();
    }

    /**
     * 删除音乐信息
     * @param deleteIds
     * @return
     */
    @PostMapping("/deleteMusicInfo")
    @ResponseBody
    public ResultObj deleteMusicInfo(@RequestBody List<String> deleteIds){
        try{
            return webMusicServer.deleteMusicInfo(deleteIds);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultObj.fail();
    }

    @PostMapping("/uploadMusicFile")
    @ResponseBody
    public ResultObj uploadMusicFile(WebMusicBean webMusicBean, @RequestParam(value = "file",required = false) MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                if(null != webMusicBean.getFileType()) {
                    String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                    String musicId = IdUtil.getUUID();
                    if(null == webMusicBean.getMusicId() || "".equals(webMusicBean.getMusicId())){
                        webMusicBean.setMusicId(musicId);
                    }
                    String fileurl = FileUploadUtil.upload(LylBlogConfig.getMusicfile(), file, webMusicBean.getMusicId(), suffix);
                    webMusicBean.setFileName(file.getOriginalFilename());
                    webMusicBean.setFileUrl(fileurl);
                    return webMusicServer.uploadMusicFile(webMusicBean);
                }else{
                    return ResultObj.fail("文件类型为空！");
                }
            }
            return ResultObj.fail();
        } catch (Exception e) {
            return ResultObj.fail(e.getMessage());
        }
    }

    @RequestMapping(value = "/downloadMusicFile", method = RequestMethod.GET)
    public void downloadMusicFile(String musicId, String fileType, HttpServletResponse response){
        try{
            //获取文件路径
            String fileUrl = webMusicServer.getFileUrl(musicId, fileType);
            //获取文件名称
            String fileName = webMusicServer.getFileName(musicId, fileType);
            FileDownloadUtil.download(response, LylBlogConfig.getMusicfile() + "/" +fileUrl, fileName, "UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
