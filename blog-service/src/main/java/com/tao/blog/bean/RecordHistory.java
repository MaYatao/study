package com.tao.blog.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author tao
 * @Description 点赞表
 * @date 2019/11/7 15:52
 **/
@Entity
@Table(name = "tb_blog_record")
@Data
public class RecordHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int brId;
    /**
     * 点赞评论者
     */
    @Column(name = "from_user")
    private int fromUser;
    /**
     * 被点赞评论者
     */
    @Column(name = "to_user")
    private int toUser;
    /**
     * 被点赞的评论
     */
    @Column(name = "comment_id")
    private int commentId;
    /**
     * 被点赞的文章
     */
    @Column(name = "content_id")
    private int contentId;
    /**
     * 点赞时间
     */
    @Column(name = "aggree_time")
    private String aggreeTime;
    /**
     * 评论时间
     */
    @Column(name = "comment_time")
    private String commentTime;
    @Column(name = "course_id")
    private Integer courseId;
    /**ß
     * 访问时间
     */
    @Column(name = "view_time")
    private String viewTime;
}
