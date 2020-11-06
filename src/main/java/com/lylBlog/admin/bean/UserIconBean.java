package com.lylBlog.admin.bean;

/**
 * 用户头像实体类
 */
public class UserIconBean {

    private String iconid;//用户头像id
    private String userId;//用户id
    private String iconUrl;//头像url路径
    private String isActivity;//标记该头像可否可用
    private String createtime;//创建时间

    public String getIconid() {
        return iconid;
    }

    public void setIconid(String iconid) {
        this.iconid = iconid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getIsActivity() {
        return isActivity;
    }

    public void setIsActivity(String isActivity) {
        this.isActivity = isActivity;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}
