package com.lylBlog.admin.bean;

/**
 * @Author: lyl
 * @Date: 2020/12/2 19:38
 */
public class ArticleBean {

    private String articleId;          //   文章编号
    private String columnId;           //	所属栏目编号
    private String articleTitle;       //	文章标题
    private String abstracts;          //	文章摘要
    private String content;            //	文章内容
    private String copyFrom;           //	文章来源
    private String fromWay;            //	文章来源方式（1、原创  2、转载）
    private String fromUrl;            //	文章来源网址
    private String authorId;           //	文章发布人
    private String articleLabel;       //	文章标签
    private String hits;               //	点击数
    private String postNum;            //	评论数
    private String onTop;              //	是否置顶
    private String iselite;            //	是否推荐
    private String thumb;              //	浓缩图路径
    private String articleStatus;      //	文章状态（草稿、审核、正常）
    private String createTime;         //	文章发布时间
    private String updateTime;         //	更新时间

}
