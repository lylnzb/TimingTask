package com.lylBlog.user.server.impl;

import com.lylBlog.common.bean.ResultObj;
import com.lylBlog.common.util.DateUtil;
import com.lylBlog.common.util.IdUtil;
import com.lylBlog.common.util.ShiroUtils;
import com.lylBlog.login.bean.UserBean;
import com.lylBlog.user.bean.PermissionBean;
import com.lylBlog.user.bean.RoleBean;
import com.lylBlog.user.mapper.UserMapper;
import com.lylBlog.user.server.UserServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServerImpl implements UserServer {

    @Resource
    private UserMapper userMapper;

    /**
     * 查询所有用户信息
     * @param userBean
     * @return
     */
    @Override
    public ResultObj queryUserList(UserBean userBean) throws Exception{

        List<UserBean> userList = userMapper.queryUserList(userBean);
        int count = userMapper.queryUserListCount(userBean);
        return ResultObj.ok(count,userList);
    }

    /**
     * 查询所有角色信息
     * @param roleBean
     * @return
     * @throws Exception
     */
    @Override
    public ResultObj queryRoleList(RoleBean roleBean) throws Exception {
        List<RoleBean> roleList = userMapper.queryRoleList(roleBean);
        int count = userMapper.queryRoleListCount(roleBean);
        return ResultObj.ok(count,roleList);
    }

    /**
     * 新增角色信息
     * @param roleBean
     * @return
     * @throws Exception
     */
    @Override
    public ResultObj addRoleInfo(RoleBean roleBean) throws Exception{
        UserBean userBean = ShiroUtils.getUserInfo();

        roleBean.setRoleid(IdUtil.getGUID());//权限id
        roleBean.setCreateperson(userBean.getId());//创建人id
        roleBean.setCreatetime(DateUtil.getCurrentDatetime());//创建时间
        int count = userMapper.addRoleInfo(roleBean);
        if(count == 0){
            return ResultObj.fail("角色新增失败");
        }else{
            return ResultObj.ok("角色新增成功");
        }
    }

    /**
     * 查询所有权限信息
     * @param permissionBean
     * @return
     * @throws Exception
     */
    @Override
    public ResultObj queryPermInfo(PermissionBean permissionBean) throws Exception{

        return ResultObj.ok();
    }

    /**
     * 新增权限信息
     * @param permissionBean
     * @return
     * @throws Exception
     */
    @Override
    public ResultObj addPermInfo(PermissionBean permissionBean) throws Exception{
        //获取当前用户信息
        UserBean userBean = ShiroUtils.getUserInfo();

        //权限类型为按钮,并且父级权限ID为空，则给出提示
        if("2".equals(permissionBean.getPermType())
              && (null == permissionBean.getParentId() || "".equals(null == permissionBean.getParentId()))){
            return ResultObj.fail("请选择上级菜单！");
        }

        //权限类型为目录,或者父级权限ID为空,默认父级权限ID为0
        if(!"2".equals(permissionBean.getPermType())
              || null == permissionBean.getParentId()
              || "".equals(permissionBean.getParentId())){
            permissionBean.setParentId("0");//0代表第一级
        }
        permissionBean.setCreateperson(userBean.getId());//创建人id
        permissionBean.setCreatetime(DateUtil.getCurrentDatetime());//创建时间
        int count = userMapper.addPermInfo(permissionBean);
        if(count == 0){
            return ResultObj.fail("权限新增失败");
        }else{
            return ResultObj.ok("权限新增成功");
        }
    }
}
