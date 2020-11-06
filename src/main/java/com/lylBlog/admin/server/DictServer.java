package com.lylBlog.admin.server;

import com.lylBlog.admin.bean.DictDataBean;
import com.lylBlog.admin.bean.DictTypeBean;
import com.lylBlog.common.bean.ResultObj;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictServer {

    /**
     * 查询字典类型信息
     * @param dictTypeBean
     * @return
     */
    ResultObj queryDictTypeInfo(DictTypeBean dictTypeBean);

    /**
     * 新增或编辑字典类型信息
     * @param dictTypeBean
     * @return
     */
    ResultObj addOrEditDictTypeInfo(DictTypeBean dictTypeBean, String type);

    /**
     * 删除字典类型信息
     * @param dictTypeBean
     * @return
     */
    ResultObj deleteDictTypeInfo(DictTypeBean dictTypeBean);

    /**
     * 通过条件查询字典数据信息
     * @param dictDataBean
     * @return
     */
    ResultObj queryDictDataInfo(DictDataBean dictDataBean);

    /**
     * 新增或编辑字典数据信息
     * @param dictDataBean
     * @param type
     * @return
     */
    ResultObj addOrEditDictDataInfo(DictDataBean dictDataBean, String type);

    /**
     * 删除字典数据信息
     * @param dictDataBean
     * @return
     */
    ResultObj deleteDictDataInfo(DictDataBean dictDataBean);
}
