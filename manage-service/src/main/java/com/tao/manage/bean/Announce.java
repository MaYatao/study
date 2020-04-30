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
    /**
     学生，1,老师，-1全部
     */
    private   Integer  toUser;
    @Column(name="sent_time")
     /**
     发送日期
     */
    private    String sentTime;
    private   String   content;
    private   String   title;

}
