package com.lylBlog.index.server;

import com.lylBlog.common.bean.ResultObj;
import com.lylBlog.index.bean.ArticleListBean;
import com.lylBlog.index.bean.CardBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: lyl
 * @Date: 2020/11/14 14:58
 */
public interface IndexServer {

    /**
     * 展示网站首页卡片内容信息
     * @param articleType
     * @return
     */
    ResultObj showCardInfo(String articleType);

    /**
     * 展示网站首页最新文章列表信息
     * @return
     */
    ResultObj showArticleInfo();
}
