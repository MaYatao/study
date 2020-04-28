package com.tao.blog.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author tao
 * @Description 点赞表
 * @date 2019/11/7 15:52
 **/
@Entity
@Table(name = "tb_record_history")
@Data
public class RecordHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recordHistoryId;
    /**
     * 点赞转发者
     */
    @Column(name = "from_user")
    private int fromUser;
    /**
     * 被点赞转发者
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
     * 浏览时间
     */
    @Column(name = "view_time")
    private String viewTime;
    /**
     * 评论时间
     */
    @Column(name = "comment_time")
    private String commentTime;
    /**
     * 转发时间
     */
    @Column(name = "collection_ime")
    private String collectionTime;

}
