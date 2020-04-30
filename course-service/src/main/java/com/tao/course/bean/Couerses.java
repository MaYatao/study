package com.tao.course.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author tao
 * @Description 课程
 * @date 2019/10/29 19:05
 **/
@Entity
@Table(name = "tb_couerses")
@Data
public class Couerses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;
    private String title;
    /**
     * 描述
     */
    private String description;
    /**
     * 学习基础
     */
    private String basics;
    /**
     * 学习目标
     */
    private String goal;
    /**
     * 知识点
     */
    private Integer knowledges;

    /**
     * 视频链接
     */
    @Column(name = "url")
    private String url;

    /**
     * 封面链接
     */
    @Column(name = "image_url")
    private String imageUrl;
    /**
     * 上传时间
     */
    @Column(name = "create_time")
    private String createTime;
    @Column(name = "user_id")
    private Integer userId;
    /**
     * 方向  前端，后端
     */
    @Column(name = "direction")
    private Integer direction;
    @Column(name = "degree", columnDefinition = "int default 0")
    /**
     *难度
     */
    private Integer degree;
    /**
     * 科目
     */
    @Column(name = "subject")
    private Integer subject;
}
