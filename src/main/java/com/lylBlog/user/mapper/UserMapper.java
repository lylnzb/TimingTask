package com.lylBlog.user.mapper;

import com.lylBlog.login.bean.UserBean;
import com.lylBlog.user.bean.PermissionBean;
import com.lylBlog.user.bean.RoleBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 查询所有用户信息
     * @param userBean
     * @return
     */
    List<UserBean> queryUserList(UserBean userBean);

    /**
     * 查询所有用户信息总数
     * @param userBean
     * @return
     */
    int queryUserListCount(UserBean userBean);

    /**
     * 查询所有角色信息
     * @param roleBean
     * @return
     */
    List<RoleBean> queryRoleList(RoleBean roleBean);

    /**
     * 查询所有角色信息总数
     * @param roleBean
     * @return
     */
    int queryRoleListCount(RoleBean roleBean);

    /**
     * 新增角色信息
     * @param roleBean
     * @return
     */
    int addRoleInfo(RoleBean roleBean);

    /**
     * 查询所有权限信息
     * @param permissionBean
     * @return
     */
    List<PermissionBean> queryPermInfo(PermissionBean permissionBean);

    /**
     * 新增权限信息
     * @param permissionBean
     * @return
     */
    int addPermInfo(PermissionBean permissionBean);
}
