package com.lylBlog.admin.mapper;

import com.lylBlog.admin.bean.BlogSetBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: lyl
 * @Date: 2021/1/7 16:27
 */
@Mapper
public interface BlogSetMapper {

    /**
     * 查看博客设置
     * @return
     */
    List<BlogSetBean> viewBlogSetInfo();

    /**
     * 新增博客设置
     * @param blogSetBean
     * @return
     */
    int addBlogSetInfo(BlogSetBean blogSetBean);

    /**
     * 修改博客设置
     * @param blogSetBean
     * @return
     */
    int updateBlogSetInfo(BlogSetBean blogSetBean);
}
