package com.tao.course.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author tao
 * @Description //课程目录表
 * @date 2019/11/7 16:08
 **/
@Entity
@Table(name="tb_mkdir")
@Data
public class Mkdir {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  int  mkdirId;
    private   int courceId;
    private   int   chepterId;
    private    String  title;  //目录标题
    private String    creatTime;//创建时间
}
