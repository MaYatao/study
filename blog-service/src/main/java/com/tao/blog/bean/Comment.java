package com.tao.blog.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author tao
 * @Description // 富文本编辑器
 * @date 2019/10/28 20:33
 **/

@Entity
@Table(name = "tb_comment")
@Data
public class Comment {   //评论表
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;
    @Column(name = "course_id")
    private Integer courseId;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 点赞评论者
     */
    @Column(name = "from_user")
    private Integer fromUser;
    /**
     * 被点赞评论者
     */
    @Column(name = "to_user")
    private Integer toUser;
    /**
     * 评论时间
     */
    private String commentTime;
    /**
     * 指向父评论的id,如果不是对评论的回复,那么该值为null
     */
    @Column(name = "parent_id")
    private Integer parentId;
    /**
     * 文章id
     */
    @Column(name = "content_id")
    private Integer  contentId;


    /**
     * 点赞数
     */
    @Column(name = "agree", columnDefinition = "int default 0")
    private Integer agree;

}
