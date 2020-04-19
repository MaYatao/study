package com.tao.manage.bean;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name="tb_image")
@Data
public class Image {  //公告消息表
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private   Integer imageId;

    private  String info;

    private  String url;

    private  String link; //链接

    private  Boolean status; //是的过期
    @Column(name="publish_time")
    private  String publishTime;
    @Column(name="delete_time")
    private  String deleteTime;

}
