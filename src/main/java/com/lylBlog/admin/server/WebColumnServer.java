package com.lylBlog.admin.server;

import com.lylBlog.admin.bean.WebColumnBean;
import com.lylBlog.common.bean.ResultObj;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: lyl
 * @Date: 2020/11/8 14:58
 */
public interface WebColumnServer {

    /**
     * 添加或编辑网站栏目信息
     * @param webColumnBean
     * @return
     */
    ResultObj addOrUpdateWebColumnInfo(WebColumnBean webColumnBean, String type);

    /**
     * 查询网站栏目信息
     * @return
     */
    ResultObj queryWebColumnInfo();

    /**
     * 根据id查询网站栏目信息
     * @param columnId
     * @return
     */
    ResultObj queryWebColumnInfoById(String columnId);

    /**
     * 删除网站栏目信息
     * @param deleteIds
     * @return
     */
    ResultObj deleteWebColumnInfo(List<String> deleteIds);

    /**
     * 查询所有父栏目信息
     * @return
     */
    ResultObj queryParentColumn();
}
