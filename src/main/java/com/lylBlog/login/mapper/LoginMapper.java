package com.lylBlog.login.mapper;

import com.lylBlog.admin.bean.PermissionBean;
import com.lylBlog.admin.bean.RoleBean;
import com.lylBlog.login.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LoginMapper {
    /**
     * 用户注册
     * @return
     */
    int registerUser(UserBean userBean);

    /**
     * 通过邮箱查询用户是否存在
     * @param email
     * @return
     */
    UserBean findUserByEmail(String email);

    /**
     * 新增角色与用户关联表数据
     * @param userBean
     * @return
     */
    int addUserAndRoleRelevant(UserBean userBean);

    /**
     * 删除角色与用户关联表数据
     * @param userId
     * @return
     */
    int deleteUserAndRoleRelevant(@Param("userId") String userId);

    /**
     * 查询用户所属的角色信息
     * @param email
     * @return
     */
    List<RoleBean> queryRoles(String email);

    /**
     * 查询用户所属的权限信息
     * @param email
     * @return
     */
    List<PermissionBean> queryPerms(String email);
}
