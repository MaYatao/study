package com.tao.course.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * 功能描述：  知识点之间的关系
 * @Author: 麻亚涛
 * @Date: 2020/4/16 16:44
 */
@Entity
@Table(name="tb_knowledges")
@Data
public class Knowledge {
    // 知识点id
    @Id
    @Column(name="knowledge_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private   Integer  knowledgeId;

    private  String title;
    //下一个节点们
    private String  next;
    //上一个节点
    private  String  previous;
    // 方向科目章节id
    private   Integer  subjectId;
}
