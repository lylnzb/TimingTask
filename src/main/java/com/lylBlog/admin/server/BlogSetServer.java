package com.lylBlog.admin.server;

import com.lylBlog.admin.bean.BlogSetBean;
import com.lylBlog.common.bean.ResultObj;
import org.springframework.stereotype.Service;

/**
 * @Author: lyl
 * @Date: 2021/1/7 16:44
 */
public interface BlogSetServer {

    /**
     * 查看博客设置
     * @return
     */
    ResultObj viewBlogSetInfo();

    /**
     * 配置博客设置
     * @return
     */
    ResultObj configurationBlogSetInfo(BlogSetBean blogSet);
}
