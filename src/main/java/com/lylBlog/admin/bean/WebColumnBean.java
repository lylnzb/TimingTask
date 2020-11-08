package com.lylBlog.admin.bean;

import com.lylBlog.common.bean.ParaBean;

/**
 * 网站栏目实体类
 * @Author: lyl
 * @Date: 2020/11/8 14:47
 */
public class WebColumnBean  extends ParaBean {
    private int rk;//序号

    private String columnId;//栏目编号
    private String parentId;//父栏目编号
    private String columnName;//栏目名称
    private String columnIcon;//栏目图标
    private String columnUrl;//栏目url地址
    private String isDefault;//是否终极栏目
    private String isHidden;//是否隐藏栏目
    private String keywords;//栏目关键字
    private String description;//栏目说明
    private String createBy;//创建者
    private String createTime;//创建时间
    private String updateBy;//更新者
    private String updateTime;//更新时间

    private String isMenu;//是否为菜单
    private String orderBy;//排序

    public int getRk() {
        return rk;
    }

    public void setRk(int rk) {
        this.rk = rk;
    }

    public String getColumnId() {
        return columnId;
    }

    public void setColumnId(String columnId) {
        this.columnId = columnId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnIcon() {
        return columnIcon;
    }

    public void setColumnIcon(String columnIcon) {
        this.columnIcon = columnIcon;
    }

    public String getColumnUrl() {
        return columnUrl;
    }

    public void setColumnUrl(String columnUrl) {
        this.columnUrl = columnUrl;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public String getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(String isHidden) {
        this.isHidden = isHidden;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
