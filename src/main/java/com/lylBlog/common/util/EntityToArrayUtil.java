package com.lylBlog.common.util;

import java.util.List;

/**
 * @description: list对象转二维数组 工具类
 * @Author: lyl
 * @Date: 2020/11/19 9:27
 */
public class EntityToArrayUtil {

    /**
     * 集合转二维数组
     * @param list
     * @param <T>
     * @return
     */
    public static <T> Object[][] toArray(List<T> list){
        Object[][] result = new Object[1][list.size()];

        for(int i = 0;i < result.length;i++){
            for(int j = 0;j < result[i].length;j++){
                result[i][j] = list.get(j);
            }
        }
        return result;
    }
}
