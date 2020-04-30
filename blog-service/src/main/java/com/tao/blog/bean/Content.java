package com.tao.blog.bean;


import lombok.Data;

import javax.persistence.*;

/**
 * @Author tao
 * @Description帖子文章表 富文本编辑器
 * @date 2019/10/28 17:13
 **/

@Entity
@Table(name = "tb_content")
@Data
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contentId;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(columnDefinition = "text")
    private String content;

    /**
     * 发布时间
     */
    private String createTime;
    /**
     * 发布者
     */
    @Column(name = "user_id")
    private Integer userId;
    /**
     * 点赞数
     */
    @Column(name = "agree", columnDefinition = "int default 0")
    private Integer agree;
    /**
     * 评论数
     */
    @Column(name = "comments", columnDefinition = "int default 0")
    private Integer comments;
    /**
     * 删除-1，草稿1，发布0
     */
    @Column(name = "status", columnDefinition = "int default 0")
    private Integer status;
    /**
     * 浏览量
     */
    @Column(name = "views", columnDefinition = "int default 0")
    private int views;
    /**
     * 话题
     */
    private String topic;

    /**
     * 0 学习贴  1 话题贴
     */
    @Column(name = "type", columnDefinition = "int default 0")
    private Integer type;
    /**
     * 知识点
     */
    private Integer knowledges1;
    /**
     * 知识点
     */
    private Integer knowledges2;

    /**
     * 知识点
     */
    private Integer knowledges3;
    /**
     * 是否开启评论
     */
    @Column(name = "is_comment")
    private boolean comment;

}

