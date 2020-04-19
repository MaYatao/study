package com.tao.question.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author tao
 * @Description //试题
 * @date 2019/10/29 18:51
 **/
@Entity
@Table(name="tb_question")
@Data
public class Question {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private   Integer  qid;
    private   String  options;
    @Column(name="degree" ,columnDefinition="int default 0")
    private   Integer    degree;    //问题难度
    private   String  content;  //试题内容
    private   Integer   type;    //试题类型  0 大题  1单择题
    private   String  answer;     //答案
    private   String    knowledge ;   //知识点
    @Column(name="score" ,columnDefinition="int default 0")
    private   int    score;        //分值
    @Column(name="uid" ,columnDefinition="int default 0")
    private   int    uid; //  作者
    @Column(name="direction")
    private   Integer     direction;  //方向  前端，后端
    @Column(name="subject")
    private   Integer     subject; //科目
    private  String  analysis;   //解析
    @Column(name="create_time")
    private String    createTime;  //创建时间
}
