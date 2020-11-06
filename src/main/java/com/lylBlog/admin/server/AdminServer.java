package com.lylBlog.admin.server;

import com.lylBlog.admin.bean.MenuBean;
import com.lylBlog.admin.bean.PermissionBean;
import com.lylBlog.admin.bean.RoleBean;
import com.lylBlog.admin.bean.UserIconBean;
import com.lylBlog.common.bean.ResultObj;
import com.lylBlog.login.bean.UserBean;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AdminServer {

    /**
     * 查询所有用户信息
     * @param userBean
     * @return
     */
    ResultObj queryUserList(UserBean userBean) throws Exception;

    /**
     * 新增或修改用户信息
     * @param userBean
     * @return
     */
    ResultObj addOrEditUserInfo(UserBean userBean, String type) throws Exception;

    /**
     * 停用账号
     * @param userIds
     * @return
     */
    ResultObj disableUserInfo(List<String> userIds);

    /**
     * 上传头像
     * @param userIcon
     * @return
     */
    ResultObj uploadIcon(UserIconBean userIcon);

    /**
     * 密码重置
     * @param emails
     * @return
     */
    ResultObj resetPassword(List<String> emails);

    /**
     * 查询所有角色信息
     * @param roleBean
     * @return
     */
    ResultObj queryRoleList(RoleBean roleBean) throws Exception;

    /**
     * 新增或修改角色信息
     * @param roleBean
     * @return
     */
    ResultObj addRoleInfo(RoleBean roleBean, String type) throws Exception;

    /**
     * 删除角色信息
     * @param deleteIds
     * @return
     */
    ResultObj deleteRoleInfo(List<String> deleteIds);

    /**
     * 查询所有权限信息
     * @param permissionBean
     * @return
     */
    ResultObj queryPermInfoToTree(PermissionBean permissionBean) throws Exception;

    /**
     * 通过条件查询权限详情
     * @param permissionBean
     * @return
     */
    ResultObj qeuryPermInfoByConditions(PermissionBean permissionBean) throws Exception;

    /**
     * 新增权限信息
     * @param permissionBean
     * @return
     */
    ResultObj addPermInfo(PermissionBean permissionBean,String type) throws Exception;

    /**
     * 取消或者恢复权限功能
     * @param permIds
     * @param valid
     * @return
     * @throws Exception
     */
    ResultObj cancelOrRestorePermInfo(List<Map<String,Object>> permIds, String valid) throws Exception;

    /**
     * 查询菜单数据结构
     * @return
     */
    ResultObj queryMenuInfo() throws Exception;
}
