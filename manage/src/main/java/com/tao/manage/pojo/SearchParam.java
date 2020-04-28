package com.tao.manage.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 功能描述：
 *
 * @Author: 麻亚涛
 * @Date: 2020/4/26 10:01
 */
@Data
public class SearchParam {
    private String id;

    private   String  description;  // 课程描述
    private   String   basics;   //学习基础
    private    String  goal  ;   //学习目标
    private   String  knowledges ;   //知识点

    private String userName;


    private Integer age;


    private Date birthday;


    private String description;
    private String roleName;
}
