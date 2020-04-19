package com.tao.common.bean;

import lombok.Data;

import java.util.Date;
@Data
public class BlogResult {
    private  String username;
    private  int userId;
    private   String  headImage;  //头像
    private Integer contentId;
    private  String  title;//标题
    private String content;  //内容
    private String contentTime;   //发布时间
    private int comments;   //点赞数
    private int agree;   //点赞数
    private int status;    //删除-1，草稿1，发布0
    private int collection; //转发数
    private  int  views;  //浏览量
    private  String flag ;  //标签
    private  boolean comment;  //是否开启评论



}
