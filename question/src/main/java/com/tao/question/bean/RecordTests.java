package com.tao.question.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author tao
 * @Description //测试记录
 * @date 2019/10/29 19:20
 **/
@Entity
@Table(name="tb_record_tests")
@Data
public class RecordTests {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private   Integer rtid;
    @Column(name="user_id")
    private  int  userId;
    @Column(name="test_id")
    private     Integer   testId;  //测试
    private String title;//测试名
    @Column(name="total_score" ,columnDefinition="int default 0")
    private   int     totalScore;  //得分
    @Column(name="true_num" ,columnDefinition="int default 0")
    private   int      trueNum;
    @Column(name="total_num" ,columnDefinition="int default 0")
    private  int totalNum;
    @Column(name="ststus" ,columnDefinition="int default 0")
    private  int ststus;   //试题难度
    private  String    date; //完成记录
    private  String  spendTime;  //



}
