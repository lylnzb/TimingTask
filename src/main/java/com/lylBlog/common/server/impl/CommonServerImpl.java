package com.lylBlog.common.server.impl;

import com.alibaba.fastjson.JSONArray;
import com.lylBlog.admin.bean.DictDataBean;
import com.lylBlog.common.bean.MusicBean;
import com.lylBlog.common.bean.ResultObj;
import com.lylBlog.common.config.LylBlogConfig;
import com.lylBlog.common.mapper.CommonMapper;
import com.lylBlog.common.server.CommonServer;
import com.lylBlog.common.util.EntityToArrayUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommonServerImpl implements CommonServer {

    @Resource
    private CommonMapper commonMapper;

    /**
     * 根据编码类别查询字典
     * @param dictType
     * @return
     */
    public ResultObj queryCodeValue(String dictType){
        List<DictDataBean> dictDataList = commonMapper.queryCodeValue(dictType);
        return ResultObj.ok(dictDataList);
    }

    /**
     * 查询音乐列表
     * @return
     */
    public Object[][] queryMusicList(){
        List<MusicBean> musicList = commonMapper.queryMusicList();

        for(MusicBean music : musicList){
            music.setImg(LylBlogConfig.getBasePath() + "musicfile/" + music.getImg());
            music.setSrc(LylBlogConfig.getBasePath() + "musicfile/" + music.getSrc());
        }
        System.out.println(EntityToArrayUtil.toArray(musicList).toString());
        return EntityToArrayUtil.toArray(musicList);
    }
}
