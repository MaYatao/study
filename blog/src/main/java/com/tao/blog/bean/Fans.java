package com.tao.blog.bean;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author tao
 * @Description //关注者表
 * @date 2019/10/28 20:43
 **/
@Entity
@Table(name="tb_fans")
@Data
public class Fans {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  int  fansId;
    private   int  follwoee;  //关注
    private    int  fans;  //被关注
    private    Date   follwerTime;  //关注时间
    private   int   type  ;//类型

}
