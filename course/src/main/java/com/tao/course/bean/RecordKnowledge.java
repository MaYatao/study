package com.tao.course.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * 功能描述：
 *
 * @Author: 麻亚涛
 * @Date: 2020/4/29 10:56
 */
@Entity
@Table(name="tb_knowledge_record_")
@Data
public class RecordKnowledge {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private   Integer  rkid;
    private   Integer  userId;
    //
    private   Integer   knowledgeId;

}
