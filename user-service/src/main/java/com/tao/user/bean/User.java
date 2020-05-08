package com.tao.user.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author tao
 * @Description TODO
 * @date 2019/10/28 19:00
 **/
@Entity
@Table(name = "tb_user")
@Data
public class User {


    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     *用户Id
     */
    private Integer userId;
    private String username;
    private String password;
    private String birthday;
    private String joinDay;
    private String headImage;
    private Boolean sex ;
    private String school;
    /**
     * 身份 0学生，1教师，2管理员
     */

    private Integer identity;
    /**
     * 方向
     */
    private Integer direction;
    /**
     * 个人简介
     */
    private String description;


}
