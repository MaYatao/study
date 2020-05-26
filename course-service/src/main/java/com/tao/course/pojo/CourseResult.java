package com.tao.course.pojo;

import com.tao.course.bean.Couerses;
import lombok.Data;

import javax.persistence.Column;

@Data
public class CourseResult   {
    private Integer courseId;
    private String title;

    private String description;

    private String basics;

    private String goal;

    private Integer Knowledge1;
    private String Knowledge1Name;

    private Integer Knowledge2;
    private String Knowledge2Name;

    private Integer knowledges3;
    private String knowledges3Name;

    private String url;

    private String imageUrl;

    private String createTime;

    private Integer userId;

    private   String    username;

    private Integer direction;

    private Integer degree;

    private Integer subject;




}
