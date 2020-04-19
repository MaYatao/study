package com.tao.question.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author tao
 * @Description //试卷
 * @date 2019/10/29 18:37
 **/
@Entity
@Table(name="tb_test")
@Data
public class Tests {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer testId;
    private String title;//测试名
    @Column(name="test_time")
    private String testTime; //创建时间
    @Column(name="blank_score")
    private int blankScore;  //总分数
    @Column(name="user_id")
    private   int    userId; //  作者
    @Column(name="socre" ,columnDefinition="int default 0")
    private int socre;      //得分
    @Column(name="content_questios")
    private String contentQuestios;  //内容试题
    @Column(name="choice_questios")
    private String choiceQuestios;  //内容试题
    @Column(name="choices_questios")
    private String choicesQuestios;  //内容试题
    @Column(name="count" ,columnDefinition="int default 0")
    private int count;     //试题数
    @Column(name="type" ,columnDefinition="int default 0")
    private  int type;   //0 表示专项训练，1表示习题
    @Column(name="status" ,columnDefinition="int default 0")
    private  int status;   //试题难度
    private String other;   //备注
    @Column(name="views" ,columnDefinition="int default 0")
    private  int views ;
}
