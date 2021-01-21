package com.lylBlog.common.server;

import com.lylBlog.admin.bean.BlogSetBean;
import com.lylBlog.common.bean.MusicBean;
import com.lylBlog.common.bean.ResultObj;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommonServer {

    /**
     * 根据编码类别查询字典
     * @param dictType
     * @return
     */
    ResultObj queryCodeValue(String dictType);

    /**
     * 查询音乐列表
     * @return
     */
    Object[][] queryMusicList();

    /**
     * 导航栏初始化
     * @return
     */
    ResultObj queryMeunInfo();

    /**
     * 获取博客配置信息
     * @return
     */
    BlogSetBean getBlogConfiguration();
}
