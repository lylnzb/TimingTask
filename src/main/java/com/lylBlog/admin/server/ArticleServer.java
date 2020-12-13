package com.lylBlog.admin.server;


import com.lylBlog.admin.bean.LabelBean;
import com.lylBlog.common.bean.ResultObj;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleServer {

    /**
     * 查询标签信息
     * @param label
     * @return
     */
    ResultObj queryLabelInfo(LabelBean label);

    /**
     * 新增标签
     * @param label
     * @return
     */
    ResultObj addOrUpdaLabelInfo(LabelBean label, String type);

    /**
     * 删除标签
     * @param deleteIds
     * @return
     */
    ResultObj deleteLabelInfo(List<String> deleteIds);
}
