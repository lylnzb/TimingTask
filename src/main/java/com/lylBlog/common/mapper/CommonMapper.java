package com.lylBlog.common.mapper;

import com.lylBlog.admin.bean.DictDataBean;
import com.lylBlog.common.bean.MenuBean;
import com.lylBlog.common.bean.MusicBean;
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

    /**
     * 查询音乐列表
     * @return
     */
    List<MusicBean> queryMusicList(@Param("gedan") String gedan);

    /**
     * 导航栏初始化
     * @return
     */
    List<MenuBean> queryMeunInfo(@Param("isDefault") String isDefault, @Param("columnId") String columnId);
}
