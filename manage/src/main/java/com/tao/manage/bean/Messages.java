package com.tao.manage.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author tao
 * @Description公告消息表
 * @date 2019/10/28 20:36
 **/
@Entity
@Table(name = "tb_message")
@Data
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer messageId;
    /**
     * f者
     */

    @Column(name = "from_User")
    private Integer fromUser;
    /**
     * f者
     */
    @Column(name = "to_User")
    private Integer toUser;
    @Column(name = "sent_time")
    private String sentTime;
    /**
     * 文章id
     */
    @Column(name = "content_id")
    private Integer contentId;
    /**
     * I
     */
    @Column(name = "course_id")
    private Integer courseId;
    /**
     * 只有公告用
     */
    private String content;
    /**
     * 只有公告用
     */
    private String title;
    @Column(name = "status", columnDefinition = "boolean default false")
    /**
     *状态，是否已读
     */
    private Boolean status = false;
    @Column(name = "type", columnDefinition = "int default 0")
    /**
     *消息类型  0公告，1评论 2赞 3收藏
     */
    private Integer type;

}
