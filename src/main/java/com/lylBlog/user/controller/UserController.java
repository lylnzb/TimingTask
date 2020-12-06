package com.lylBlog.user.controller;

import com.lylBlog.common.bean.ResultObj;
import com.lylBlog.login.bean.UserBean;
import com.lylBlog.user.bean.PermissionBean;
import com.lylBlog.user.bean.RoleBean;
import com.lylBlog.user.server.UserServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/")
public class UserController {

    @Resource
    private UserServer userServer;

    private static String USERBASEPATH = "admin/user";
    private static String ROLEBASEPATH = "admin/role";
    private static String PERMBASEPATH = "admin/permission";

    @RequestMapping("/user/userList")
    public String userList(Model model){
        return USERBASEPATH + "/userList";
    }

    @RequestMapping("/user/addOrUpdaUser")
    public String addOrUpdaUser(Model model){
        return USERBASEPATH + "/addOrUpdaUser";
    }

    @RequestMapping("/role/roleList")
    public String roleList(Model model){
        return ROLEBASEPATH + "/roleList";
    }

    @RequestMapping("/role/addOrUpdaRole")
    public String addOrUpdaRole(Model model){
        return ROLEBASEPATH + "/addRole";
    }

    @RequestMapping("/perm/permissionList")
    public String permissionList(Model model){
        return PERMBASEPATH + "/permissionList";
    }

    @RequestMapping("/perm/addOrUpdaPermission")
    public String addOrUpdaPermission(Model model){
        return PERMBASEPATH + "/addPermission";
    }

    @RequestMapping("/userCenter")
    public String userCenter(Model model){
        return "/user/userCenter";
    }
    
    /**
     * 查询所有用户信息
     * @param userBean
     * @return
     */
    @RequestMapping("/user/queryUserList")
    @ResponseBody
    public ResultObj queryUserList(@RequestBody UserBean userBean){
        try {
            return userServer.queryUserList(userBean);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询所有角色信息
     * @param roleBean
     * @return
     */
    @RequestMapping("/user/queryRoleList")
    @ResponseBody
    public ResultObj queryRoleList(@RequestBody RoleBean roleBean){
        try {
            return userServer.queryRoleList(roleBean);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 新增角色信息
     * @param roleBean
     * @return
     */
    @RequestMapping("/user/addRoleInfo")
    @ResponseBody
    public ResultObj addRoleInfo(@RequestBody RoleBean roleBean){
        try {
            return userServer.addRoleInfo(roleBean);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询所有权限信息
     * @param permissionBean
     * @return
     */
    @RequestMapping("/user/queryPermInfo")
    @ResponseBody
    public ResultObj queryPermInfo(@RequestBody PermissionBean permissionBean){
        try {
            return userServer.queryPermInfo(permissionBean);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 新增权限信息
     * @param permissionBean
     * @return
     */
    @RequestMapping("/user/addPermInfo")
    @ResponseBody
    public ResultObj addPermInfo(@RequestBody PermissionBean permissionBean){
        try {
            return userServer.addPermInfo(permissionBean);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
