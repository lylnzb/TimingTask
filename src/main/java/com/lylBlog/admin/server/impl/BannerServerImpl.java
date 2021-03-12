package com.lylBlog.admin.server.impl;

import com.lylBlog.admin.bean.BannerBean;
import com.lylBlog.admin.bean.WebMusicBean;
import com.lylBlog.admin.mapper.BannerMapper;
import com.lylBlog.admin.server.BannerServer;
import com.lylBlog.common.bean.ResultObj;
import com.lylBlog.common.config.LylBlogConfig;
import com.lylBlog.common.util.ShiroUtils;
import com.lylBlog.common.util.file.FileUtil;
import com.lylBlog.login.bean.UserBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: lyl
 * @Date: 2021/1/20 19:30
 */
@Service
public class BannerServerImpl implements BannerServer {

    @Resource
    private BannerMapper bannerMapper;

    /**
     * 查询所有轮播图信息
     * @param bannerBean
     * @return
     */
    public ResultObj queryBannerInfo(BannerBean bannerBean){
        int count = bannerMapper.queryBannerInfoCount(bannerBean);
        if(count > 0){
            List<BannerBean> webMusicList = bannerMapper.queryBannerInfo(bannerBean);
            return ResultObj.ok(count, webMusicList);
        }
        return ResultObj.ok();
    }

    /**
     * 新增轮播图信息
     * @param bannerBean
     * @return
     */
    public ResultObj addOrUpdaBannerInfo(BannerBean bannerBean, String type){
        //获取当前用户信息
        UserBean userBean = ShiroUtils.getUserInfo();
        //新增
        if("add".equals(type)){
            bannerBean.setCreateBy(userBean.getId());//创建人id
            int count = bannerMapper.addBannerInfo(bannerBean);
            if(count == 0){
                return ResultObj.fail("新增失败");
            }else{
                return ResultObj.ok("新增成功");
            }
        }else if("update".equals(type)){//修改
            bannerBean.setUpdateBy(userBean.getId());//修改人id
            int count = bannerMapper.updateBannerInfo(bannerBean);
            if(count == 0){
                return ResultObj.fail("修改失败");
            }else{
                return ResultObj.ok("修改成功");
            }
        }else{
            return ResultObj.fail("请选择类型！");
        }
    }

    /**
     * 删除轮播图信息
     * @param deleteIds
     * @return
     */
    public ResultObj deleteBannerInfo(@RequestBody List<String> deleteIds){
        int count = bannerMapper.deleteBannerInfo(deleteIds);
        if(count > 0){
            return ResultObj.ok("删除成功");
        }else{
            return ResultObj.ok("删除失败");
        }
    }
}
