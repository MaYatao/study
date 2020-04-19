package com.tao.course.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author tao
 * @Description //课程
 * @date 2019/10/29 19:05
 **/
@Entity
@Table(name="tb_couerses")
@Data
public class Couerses {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private   Integer  courseId;
    private   String  title;
    private   String  description;  //描述
    private   String   basics;   //学习基础
    private    String  goal  ;   //学习目标
    private   String  knowledges ;   //知识点
    @Column(name="url")
    private   String  url;     //视频或者资源链接
    @Column(name="source")
    private   String  source;
    @Column(name="image_url")
    private   String  imageUrl;     //封面链接
    @Column(name="upload_time")

    private   String     uploadTime;   //上传时间
    @Column(name="user_id")
    private   int    userId; //  作者
    @Column(name="direction")
    private   Integer     direction;  //方向  前端，后端
    @Column(name="degree",columnDefinition="int default 0")
    private   Integer     degree ;//难度
    @Column(name="subject")
    private   Integer     subject; //科目
}
