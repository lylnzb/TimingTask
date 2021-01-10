package com.lylBlog.admin.server.impl;

import com.lylBlog.admin.bean.BlogSetBean;
import com.lylBlog.admin.mapper.BlogSetMapper;
import com.lylBlog.admin.server.BlogSetServer;
import com.lylBlog.common.bean.ResultObj;
import com.lylBlog.common.util.ShiroUtils;
import com.lylBlog.common.util.file.FileUtil;
import com.lylBlog.login.bean.UserBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: lyl
 * @Date: 2021/1/7 16:44
 */
@Service
public class BlogSetServerImpl implements BlogSetServer {

    @Resource
    private BlogSetMapper blogSetMapper;

    /**
     * 查看博客设置
     * @return
     */
    public ResultObj viewBlogSetInfo(){
        List<BlogSetBean> blogSetList = blogSetMapper.viewBlogSetInfo();
        return ResultObj.ok(blogSetList.size(), blogSetList);
    }

    /**
     * 配置博客设置
     * @return
     */
    public ResultObj configurationBlogSetInfo(BlogSetBean blogSet){
        //获取当前用户信息
        UserBean userBean = ShiroUtils.getUserInfo();

        List<BlogSetBean> blogSetList = blogSetMapper.viewBlogSetInfo();
        if(blogSetList.isEmpty()){
            blogSet.setCreateBy(userBean.getId());//创建人id
            int count = blogSetMapper.addBlogSetInfo(blogSet);
            if(count == 0){
                return ResultObj.fail("配置失败");
            }else{
                return ResultObj.ok("配置成功");
            }
        }else{
            blogSet.setUpdateBy(userBean.getId());//修改人id
            int count = blogSetMapper.updateBlogSetInfo(blogSet);
            if(count == 0){
                return ResultObj.fail("配置失败");
            }else{
                return ResultObj.ok("配置成功");
            }
        }
    }
}
