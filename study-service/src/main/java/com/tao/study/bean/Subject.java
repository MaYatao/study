package com.tao.study.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/11/7 16:08
 **/
@Entity
@Table(name="tb_subject")
@Data
public class Subject {

    @Id
    @Column(name="subject_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private   Integer  subjectId;  // 方向科目章节id
    private  String  title;
    @Column(name="parent_id")
    private  Integer    parentId;   //方向

}
