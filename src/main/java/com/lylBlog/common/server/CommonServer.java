package com.lylBlog.common.server;

import com.lylBlog.common.bean.ResultObj;

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
}
