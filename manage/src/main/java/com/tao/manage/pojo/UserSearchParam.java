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
public class UserSearchParam {
    private String id;


    private String userName;


    private Integer age;


    private Date birthday;


    private String description;
    private String roleName;
}
