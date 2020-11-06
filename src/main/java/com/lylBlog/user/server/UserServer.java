package com.lylBlog.user.server;

import com.lylBlog.common.bean.ResultObj;
import com.lylBlog.login.bean.UserBean;
import com.lylBlog.user.bean.PermissionBean;
import com.lylBlog.user.bean.RoleBean;

import java.util.List;

public interface UserServer {

    /**
     * 查询所有用户信息
     * @param userBean
     * @return
     */
    ResultObj queryUserList(UserBean userBean) throws Exception;

    /**
     * 查询所有角色信息
     * @param roleBean
     * @return
     */
    ResultObj queryRoleList(RoleBean roleBean) throws Exception;

    /**
     * 新增角色信息
     * @param roleBean
     * @return
     */
    ResultObj addRoleInfo(RoleBean roleBean) throws Exception;

    /**
     * 查询所有权限信息
     * @param permissionBean
     * @return
     */
    ResultObj queryPermInfo(PermissionBean permissionBean) throws Exception;

    /**
     * 新增权限信息
     * @param permissionBean
     * @return
     */
    ResultObj addPermInfo(PermissionBean permissionBean) throws Exception;
}
