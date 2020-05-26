package com.tao.question.pojo;

import lombok.Data;

@Data
public class QuestionResult {
    private int rqid;
    private int qid;
    private Integer testId;

    private String dateTime;
    private int userId;
    private Boolean error = true;
    private int score;
    private String options;
    private Integer degree;
    private String content;
    private Integer type;
    private String answer;
    private String userAnswer;
    private Integer knowledge1;
    private Integer knowledge2;
    private Integer knowledge3;
    private String analysis;


}
