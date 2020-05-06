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
  /**
     链接
     */
    private  String link; //
  /**
     是的过期
     */
    private  Boolean status; //
    @Column(name="publish_time")
    private  String publishTime;

}
