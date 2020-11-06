package com.lylBlog.user.bean;

import com.lylBlog.common.bean.ParaBean;

/**
 * 用户角色信息实体类
 */
public class RoleBean extends ParaBean {
    private String rk;//序号

    private String roleid;//角色id
    private String rolename;//角色名称
    private String roledesc;//角色描述
    private String valid;//有效标志[1:有效,0:无效]
    private String createperson;//创建人
    private String createtime;//创建时间
    private String modifyperson;//修改人
    private String modifytime;//修改时间

    private String treeList;//权限树

    public String getRk() {
        return rk;
    }

    public void setRk(String rk) {
        this.rk = rk;
    }

    public String getTreeList() {
        return treeList;
    }

    public void setTreeList(String treeList) {
        this.treeList = treeList;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoledesc() {
        return roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getCreateperson() {
        return createperson;
    }

    public void setCreateperson(String createperson) {
        this.createperson = createperson;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getModifyperson() {
        return modifyperson;
    }

    public void setModifyperson(String modifyperson) {
        this.modifyperson = modifyperson;
    }

    public String getModifytime() {
        return modifytime;
    }

    public void setModifytime(String modifytime) {
        this.modifytime = modifytime;
    }
}
