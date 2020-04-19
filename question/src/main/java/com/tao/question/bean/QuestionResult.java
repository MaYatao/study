package com.tao.question.bean;

import lombok.Data;

@Data
public class QuestionResult {
    private  int rqid;
    private   int qid;  //问题Id
    private   Integer  testId;    //测试名

    private   String dateTime ;   //做题时间
    private   int    userId;      //错误用户
    private  boolean error =true ;    //是否错误
    private   int score;   //得分
    private   String  options;
    private   Integer    degree;    //问题难度
    private   String   content;  //试题内容
    private   Integer   type;    //试题类型  0 大题  1单择题
    private   String   answer;     //答案
    private  String  userAnswer;   //用户答案
    private   String    knowledge ;   //知识点
    private  String  analysis;   //解析

}
