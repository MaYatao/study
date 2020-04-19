package com.tao.blog.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author tao
 * @Description // 富文本编辑器
 * @date 2019/10/28 20:33
 **/

@Entity
@Table(name="tb_comment")
@Data
public class Comment {   //评论表
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private   Integer  commentId;
    private   String content;
    @Column(name="from_User")
    private   Integer  fromUser;//点赞转发者
    @Column(name="to_User")
    private   Integer  toUser; //被点赞转发者


    private   String   commentTime;
    @Column(name="parent_id")
    private   Integer  parentId  ;	//指向父评论的id,如果不是对评论的回复,那么该值为null
    @Column(name="content_id")
    private   Integer  contentId;  //文章id
    @Column(name="course_id")
    private   Integer  courseId;  //文章id
    @Column(name="agree",columnDefinition="int default 0")
    private   Integer  agree; //点赞数


}
