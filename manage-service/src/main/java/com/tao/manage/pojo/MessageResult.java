package com.tao.manage.pojo;

import lombok.Data;

@Data
public class MessageResult {
    private   int messagesId;


    private   Integer  fromUser;//转发者
    private  String fromUserName;
    private  String fromUserImage;
    private   Integer  toUser; //转发者
    private  String toUserName;
    private   String toUserImage;
    private   String  title;  //只有公告用
    private   Integer  contentId;  //文章id
    private   Integer  courseId;  //文章id
    private    String sentTime;  //发送日期
    private   String  content;
    private   Boolean  status =false;   //状态，是否已读
    private   int    type;     // 消息类型  0公告，1评论 2赞 3收藏
}
