package com.lylBlog.common.mapper;

import com.lylBlog.admin.bean.DictDataBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommonMapper {

    /**
     * 根据编码类别查询字典
     * @param dictType
     * @return
     */
    List<DictDataBean> queryCodeValue(@Param("dictType") String dictType);
}
