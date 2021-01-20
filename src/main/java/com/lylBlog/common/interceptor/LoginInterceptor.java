package com.lylBlog.common.interceptor;

import com.lylBlog.admin.bean.BlogSetBean;
import com.lylBlog.admin.mapper.BlogSetMapper;
import com.lylBlog.common.config.LylBlogConfig;
import com.lylBlog.common.mapper.CommonMapper;
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
    private CommonMapper commonMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        boolean flag = false;
        try{
            StringBuffer url = request.getRequestURL();
//            if(url.toString().contains(".html")){
//                response.sendRedirect("/error/404");
//            }

            flag = ShiroUtils.isAuthenticated();
            request.setAttribute("isAuthenticated", flag);//判断用户是否登录
            request.setAttribute("basePath", LylBlogConfig.getBasePath());//项目基础路径

            /*获取博客配置信息*/
            BlogSetBean blogSet = commonMapper.getBlogConfiguration();
            request.setAttribute("blogSet", blogSet);
        }catch (Exception e){
            System.out.println("我要忽略你。。。");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
