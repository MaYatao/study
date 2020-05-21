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

    private Integer knowledges1;
    private String knowledges1Name;

    private Integer knowledges2;
    private String knowledges2Name;

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
