package com.tao.course.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * 功能描述：  知识点之间的关系
 * @Author: 麻亚涛
 * @Date: 2020/4/16 16:44
 */
@Entity
@Table(name="tb_keys")
@Data
public class Keys {
    @Id
    @Column(name="key_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private   Integer  keyId;  // 知识点id

    private  String title;

    private Integer  next;  //下一个节点们
    private  Integer  previous;  //上一个节点

    @Column(name="subject_id")
    private   int  subjectId;  // 方向科目章节id
}
