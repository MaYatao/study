package com.tao.question.bean;

import lombok.Data;

import java.util.List;

@Data
public class TestResult {
    private Integer testId;
    private String title;//测试名
    private int blankScore;  //总分数
    private int socre;      //得分
    private int count;       //试题数
    private  int status;     //试题难度
    private String other;    //备注
    private List<Question> contentQuestios;  //内容试题

    private List<Question> choiceQuestios;  //内容试题

    private List<Question> choicesQuestios;  //内容试题


}
