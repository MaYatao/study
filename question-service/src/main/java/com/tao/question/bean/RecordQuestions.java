package com.tao.question.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author tao
 * @Description 错题本
 * @date 2019/10/29 18:32
 **/
@Entity
@Table(name="tb_record_quertions")
@Data
public class RecordQuestions {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  int rqid;
    /**
     *问题Id
     */
    @Column(name="qusertion_id")
    private   int qusertionId;
       /**
     *测试名
     */
    @Column(name="test_id")
    private   Integer  testId;
       /**
     *做题时间
     */
    @Column(name="date_time")
    private String   dateTime ;
       /**
     * 错误用户
     */
    @Column(name="user_id")
    private   int userId;
       /**
     * 用户答案
     */
    @Column(name="user_answer")
    private  String  userAnswer;
       /**
     * 是否错误
     */
    @Column(name="error", columnDefinition = "bit(1) default 1")
    private  Boolean error =true ;
       /**
     * 得分
     */
    @Column(name="score" ,columnDefinition="int default 0")
    private   int score;
}
