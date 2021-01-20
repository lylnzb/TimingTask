package com.lylBlog.index.server.impl;

import com.lylBlog.admin.bean.BlogSetBean;
import com.lylBlog.admin.mapper.BlogSetMapper;
import com.lylBlog.common.bean.ResultObj;
import com.lylBlog.common.util.EntityToArrayUtil;
import com.lylBlog.index.bean.ArticleListBean;
import com.lylBlog.index.bean.CardBean;
import com.lylBlog.index.bean.TabBean;
import com.lylBlog.index.mapper.IndexMapper;
import com.lylBlog.index.server.IndexServer;
import javafx.scene.control.Tab;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: lyl
 * @Date: 2020/11/14 14:59
 */
@Service
public class IndexServerImpl implements IndexServer {

    @Resource
    private IndexMapper indexMapper;

    @Resource
    private BlogSetMapper blogSetMapper;

    /**
     * 展示网站首页卡片内容信息
     * @param articleType
     * @return
     */
    public ResultObj showCardInfo(String articleType){
        String page = "6";
        List<BlogSetBean> blogSetList = blogSetMapper.viewBlogSetInfo();
        if(!blogSetList.isEmpty()){
            page = blogSetList.get(0).getBlogsetLatestShowNum().toString();
        }

        //获取选项卡信息
        List<TabBean> tabList = indexMapper.getTabInfo();
        if(tabList.isEmpty()){//如果找不打，则返回错误信息
            return ResultObj.fail();
        }

        for(TabBean tab : tabList){
            List<CardBean> cardList = indexMapper.showCardInfo(tab.getTabType(), page);
            tab.setCardList(cardList);
        }
        return ResultObj.ok(tabList);
    }

    /**
     * 展示网站首页最新文章列表信息
     * @return
     */
    public ResultObj showArticleInfo(){
        String page = "5";
        List<BlogSetBean> blogSetList = blogSetMapper.viewBlogSetInfo();
        if(!blogSetList.isEmpty()){
            page = blogSetList.get(0).getBlogsetLatestShowNum().toString();
        }
        List<ArticleListBean> articleList = indexMapper.showArticleInfo(page);
        return ResultObj.ok(articleList);
    }
}
