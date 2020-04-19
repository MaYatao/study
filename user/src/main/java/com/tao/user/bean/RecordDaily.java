package com.tao.user.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author tao
 * @Description //日常记录
 * @date 2019/10/29 19:35
 **/
@Entity
@Table(name="tb_record_daily")
@Data
public class RecordDaily {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private   int  rdid;//
    private  int  userId;
    private String  loginTime;//登录时间
    private  String  outTime;  //退出时间



}
