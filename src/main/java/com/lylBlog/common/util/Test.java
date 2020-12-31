package com.lylBlog.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @Author: lyl
 * @Date: 2020/12/17 11:30
 */
public class Test {

    public static void main(String[] args){
        String url = "/E:/IdeaProjects/TimingTask/target/classes/static/ueditor1_4_3_3/jsp/commom/config.json";
        String fileUrl = "";
        for(int i = 0;i < url.split("/").length;i++){
            if(i == 0 || i == url.split("/").length - 1 || i == url.split("/").length - 2){
                continue;
            }
            fileUrl += url.split("/")[i] + "/";
        }
        System.out.println(fileUrl);
    }
}
