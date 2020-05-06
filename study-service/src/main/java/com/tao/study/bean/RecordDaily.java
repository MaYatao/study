package com.tao.study.bean;

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
    private Integer knowledges1;
    /**
     * 知识点
     */
    private Integer knowledges2;

    /**
     * 知识点
     */
    private Integer knowledges3;



}
