package com.tao.manage.bean;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="tb_announce")
@Data
public class Announce {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private   Integer announceId;

    @Column(name="to_User",columnDefinition="int default 0")
    private   Integer  toUser; //0 ,1学生，老师，-1全部
    @Column(name="sent_time")
    private    String sentTime;  //发送日期
    private   String   content;
    private   String   title;

}
