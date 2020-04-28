package com.tao.blog.bean;

import lombok.Data;

import java.util.Date;

@Data
public class BlogResult {
    private String username;
    private int userId;
    //头像
    private String headImage;
    // 文章Id
    private Integer contentId;
    //标题
    private String title;
    //内容
    private String content;
    //发布时间
    private String contentTime;
    //评论数
    private int comments;
    //点赞数
    private int agree;
    //删除-1，草稿1，发布0
    private int status;
    //转发数
    private int collection;
    //浏览量
    private int views;
    //标签
    private String topic;
    //是否开启评论
    private boolean comment;

    private int type;
    //知识点
    private String knowledges;


}
