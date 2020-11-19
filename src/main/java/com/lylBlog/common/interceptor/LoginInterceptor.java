package com.lylBlog.common.interceptor;

import com.lylBlog.common.config.LylBlogConfig;
import com.lylBlog.common.util.ShiroUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: lyl
 * @Date: 2020/11/14 17:18
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private LylBlogConfig blogConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        boolean flag = false;
        try{
            flag = ShiroUtils.isAuthenticated();
        }catch (Exception e){
            System.out.println("我要忽略你。。。");
        }
        request.setAttribute("isAuthenticated", flag);//判断用户是否登录
        request.setAttribute("basePath", blogConfig.getBasePath());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
