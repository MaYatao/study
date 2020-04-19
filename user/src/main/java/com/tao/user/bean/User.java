package com.tao.user.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/28 19:00
 **/
@Entity
@Table(name="tb_user")
@Data
public class User  {


    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Integer  userId;  //用户Id
    private   String  username; //用户名
    private   String  password; //密码
    private   String   birthday;  //出生日期
    private   String  joinDay;  //加入时间
    private   String  headImage;  //头像
    private   String  address;  //地址
    private   boolean  sex;  //性别
    private   String   school; //学校
    private    Integer    identity;  //身份 0学生，1教师，2管理员
    private    String  position;  //教师职称
    private   String expectation ;  // 方向
    private  String   description;//个人简介


}
