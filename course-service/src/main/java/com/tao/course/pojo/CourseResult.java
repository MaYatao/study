package com.tao.course.pojo;

import lombok.Data;

@Data
public class CourseResult {
    private   Integer  courseId;
    private   String  title;
    private   String  description;  //描述
    private   String   basics;   //学习基础
    private    String  goal  ;   //学习目标
    private   String  knowledges ;   //知识点
    private   String  url;     //视频或者资源链接
    private   String  source;
    private   String  imageUrl;     //封面链接
    private String   createTime;   //上传时间
    private   int    userId; //  作者
    private   String    username; //  作者
    private   Integer     direction;  //方向  前端，后端
    private   Integer     degree ;//难度
    private   Integer     subject; //科目


}
