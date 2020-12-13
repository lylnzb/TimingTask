package com.lylBlog.admin.server.impl;

import com.lylBlog.admin.bean.LabelBean;
import com.lylBlog.admin.mapper.ArticleMapper;
import com.lylBlog.admin.server.ArticleServer;
import com.lylBlog.common.bean.ResultObj;
import com.lylBlog.common.util.ShiroUtils;
import com.lylBlog.login.bean.UserBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleServerImpl implements ArticleServer {

    @Resource
    private ArticleMapper articleMapper;

    /**
     * 查询标签信息
     * @param label
     * @return
     */
    public ResultObj queryLabelInfo(LabelBean label){
        List<LabelBean> labelList = articleMapper.queryLabelInfo(label);
        int labelCount = articleMapper.queryLabelInfoCount(label);
        return ResultObj.ok(labelCount, labelList);
    }

    /**
     * 新增或修改标签
     * @param label
     * @return
     */
    public ResultObj addOrUpdaLabelInfo(LabelBean label, String type){
        //获取当前用户信息
        UserBean userBean = ShiroUtils.getUserInfo();
        //新增
        if("add".equals(type)){
            label.setCreateBy(userBean.getId());//创建人id
            int count = articleMapper.addLabelInfo(label);
            if(count == 0){
                return ResultObj.fail("新增失败");
            }else{
                return ResultObj.ok("新增成功");
            }
        }else if("update".equals(type)){//修改
            label.setUpdateBy(userBean.getId());//修改人id
            int count = articleMapper.updateLabelInfo(label);
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
     * 删除标签
     * @param deleteIds
     * @return
     */
    public ResultObj deleteLabelInfo(List<String> deleteIds){
        int count = articleMapper.deleteLabelInfo(deleteIds);
        if(count > 0){
            return ResultObj.ok("删除成功!");
        }else {
            return ResultObj.fail("删除失败！");
        }
    }
}
