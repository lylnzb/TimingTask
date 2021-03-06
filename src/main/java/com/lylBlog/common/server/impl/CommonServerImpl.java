package com.lylBlog.common.server.impl;

import com.alibaba.fastjson.JSONArray;
import com.lylBlog.admin.bean.BlogSetBean;
import com.lylBlog.admin.bean.DictDataBean;
import com.lylBlog.common.bean.MenuBean;
import com.lylBlog.common.bean.MusicBean;
import com.lylBlog.common.bean.ResultObj;
import com.lylBlog.common.config.LylBlogConfig;
import com.lylBlog.common.mapper.CommonMapper;
import com.lylBlog.common.server.CommonServer;
import com.lylBlog.common.util.EntityToArrayUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        //查询音乐歌单数据
        List<DictDataBean> dictDataList = commonMapper.queryCodeValue("web_music_gedan");

        Map<Integer, Object> musicMap = new HashMap<Integer, Object>();
        Integer i = 1;
        for(DictDataBean dict : dictDataList) {
            List<MusicBean> musicList = commonMapper.queryMusicList(dict.getDictValue());
            for(MusicBean music : musicList){
                music.setImg(LylBlogConfig.getBasePath() + "musicfile/" + music.getImg());
                music.setSrc(LylBlogConfig.getBasePath() + "musicfile/" + music.getSrc());
            }
            musicMap.put(i, musicList);
            i++;
        }
        return EntityToArrayUtil.toArray(musicMap);
    }

    /**
     * 导航栏初始化
     * @return
     */
    public ResultObj queryMeunInfo(){
        List<MenuBean> menuList = commonMapper.queryMeunInfo("2",null);
        for(MenuBean menu : menuList){
            if("1".equals(menu.getIsDefault())){
                menu.setChildList(commonMapper.queryMeunInfo("1", menu.getId()));
            }
        }
        return ResultObj.ok(menuList.size(), menuList);
    }

    /**
     * 获取博客配置信息
     * @return
     */
    public BlogSetBean getBlogConfiguration(){
        return commonMapper.getBlogConfiguration();
    }
}
