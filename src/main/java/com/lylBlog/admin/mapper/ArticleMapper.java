package com.lylBlog.admin.mapper;

import com.lylBlog.admin.bean.LabelBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文章管理
 */
@Mapper
public interface ArticleMapper {

    /**
     * 查询标签信息
     * @param label
     * @return
     */
    List<LabelBean> queryLabelInfo(LabelBean label);

    /**
     * 查询标签信息总数
     * @param label
     * @return
     */
    int queryLabelInfoCount(LabelBean label);

    /**
     * 新增标签
     * @param label
     * @return
     */
    int addLabelInfo(LabelBean label);

    /**
     * 修改标签
     * @param label
     * @return
     */
    int updateLabelInfo(LabelBean label);

    /**
     * 删除标签
     * @param deleteIds
     * @return
     */
    int deleteLabelInfo(@Param("deleteIds") List<String> deleteIds);
}
