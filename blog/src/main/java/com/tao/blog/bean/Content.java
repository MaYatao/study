package com.tao.blog.bean;


import lombok.Data;

import javax.persistence.*;

/**
 * @Author tao
 * @Description //帖子文章表  富文本编辑器
 * @date 2019/10/28 17:13
 **/

@Entity
@Table(name="tb_content")
@Data
public class Content {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer contentId;
    private  String  title;//标题
    @Lob
    @Basic(fetch = FetchType.LAZY) @Column(columnDefinition = "text")
    private String content;  //内容
    private String contentTime;   //发布时间
    @Column(name="user_id")
    private Integer userId;  //发布者
    @Column(name="agree",columnDefinition="int default 0")
    private int agree;   //点赞数
    @Column(name="comments",columnDefinition="int default 0")
    private int comments;   //评论数
    @Column(name="status",columnDefinition="int default 0")
    private int status;    //删除-1，草稿1，发布0
    @Column(name="collection",columnDefinition="int default 0")
    private int collection; //转发数
    @Column(name="views",columnDefinition="int default 0")
    private  int  views;  //浏览量
    private  String flag ;  //标签
    @Column(name="comment")
    private  boolean comment;  //是否开启评论

}

