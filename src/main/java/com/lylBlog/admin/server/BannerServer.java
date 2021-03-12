package com.lylBlog.admin.server;

import com.lylBlog.admin.bean.BannerBean;
import com.lylBlog.common.bean.ResultObj;

import java.util.List;

/**
 * @Author: lyl
 * @Date: 2021/1/20 19:30
 */
public interface BannerServer {
    /**
     * 查询所有轮播图信息
     * @param bannerBean
     * @return
     */
    ResultObj queryBannerInfo(BannerBean bannerBean);

    /**
     * 新增轮播图信息
     * @param bannerBean
     * @return
     */
    ResultObj addOrUpdaBannerInfo(BannerBean bannerBean, String type);

    /**
     * 删除轮播图信息
     * @param deleteIds
     * @return
     */
    ResultObj deleteBannerInfo(List<String> deleteIds);
}
