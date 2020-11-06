package com.lylBlog.login.controller;

import com.lylBlog.common.bean.ResultObj;
import com.lylBlog.common.util.RedisUtil;
import com.lylBlog.login.bean.UserBean;
import com.lylBlog.login.server.LoginServer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class LoginController {

    @Resource
    private LoginServer loginServer;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 用户注册
     * @return
     */
    @RequestMapping("/registerUser")
    @ResponseBody
    public ResultObj registerUser(@RequestBody UserBean userBean, HttpServletRequest request){
        String code = (String) redisUtil.get(userBean.getEmail() + "_smslogin");   //从redis取出验证码

        if(null != code && null != userBean.getvCode()){
            if(code.equals(userBean.getvCode())){
                System.out.println(code + "===" + userBean.getvCode());
                int i = loginServer.registerUser(userBean);
                if(i == 0){
                    return ResultObj.fail(1,"该邮箱已被注册！");
                }else if(i == 1){
                    return ResultObj.ok();
                }
                else if(i == 2){
                    return ResultObj.fail(2,"注册失败");
                }
            }else{
                return ResultObj.fail(3,"该验证码已失效");
            }
        }else{
            return ResultObj.fail(3,"该验证码已失效");
        }
        return ResultObj.ok();
    }

    /**
     * 用户登录
     * @param userBean
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResultObj login(@RequestBody UserBean userBean) {
        if(userBean.getEmail() == null || "".equals(userBean.getEmail())){
            return ResultObj.fail(2,"电子邮箱不能为空");
        }

        if(userBean.getPassword() == null || "".equals(userBean.getPassword())){
            return ResultObj.fail(2,"密码不能为空");
        }

        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(userBean.getEmail(), userBean.getPassword());
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            return ResultObj.fail(1,"未知账户");
        } catch (IncorrectCredentialsException ice) {
            return ResultObj.fail(1,"密码不正确");
        } catch (LockedAccountException lae) {
            return ResultObj.fail(1,"账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            return ResultObj.fail(1,"用户名或密码错误次数过多");
        } catch (AuthenticationException ae) {
            return ResultObj.fail(1,"用户名或密码不正确");
        }
        if (subject.isAuthenticated()) {
            return ResultObj.ok("登录成功");
        } else {
            token.clear();
            return ResultObj.fail(1,"登录失败");
        }
    }

    /**
     * 用户退出登录
     * @return
     */
    @RequestMapping(value = "/loginOut", method = RequestMethod.POST)
    @ResponseBody
    public ResultObj loginOut() {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResultObj.ok();
    }
}
