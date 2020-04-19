package com.tao.manage.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/28 20:36
 **/
@Entity
@Table(name="tb_message")
@Data
public class Messages {  //公告消息表
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private   Integer messageId;

    @Column(name="from_User")
    private   Integer  fromUser;//转发者
    @Column(name="to_User")
    private   Integer  toUser; //转发者
    @Column(name="sent_time")
    private    String sentTime;  //发送日期
    @Column(name="content_id")
    private   Integer  contentId;  //文章id
    @Column(name="course_id")
    private   Integer  courseId;  //文章id
    private   String  content;  //只有公告用
    private   String  title;  //只有公告用
    @Column(name="status",columnDefinition="boolean default false")
    private   Boolean  status =false;   //状态，是否已读
    @Column(name="type",columnDefinition="int default 0")
    private   Integer    type;     // 消息类型  0公告，1评论 2赞 3收藏

}
