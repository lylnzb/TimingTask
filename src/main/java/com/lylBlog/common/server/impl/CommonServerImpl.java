package com.lylBlog.common.server.impl;

import com.lylBlog.admin.bean.DictDataBean;
import com.lylBlog.common.bean.ResultObj;
import com.lylBlog.common.mapper.CommonMapper;
import com.lylBlog.common.server.CommonServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommonServerImpl implements CommonServer {

    @Resource
    private CommonMapper commonMapper;

    /**
     * 根据编码类别查询字典
     * @param dictType
     * @return
     */
    public ResultObj queryCodeValue(String dictType){
        List<DictDataBean> dictDataList = commonMapper.queryCodeValue(dictType);
        return ResultObj.ok(dictDataList);
    }
}
