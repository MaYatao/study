package com.tao.question.pojo;

import com.tao.question.bean.Question;
import lombok.Data;

import java.util.List;

@Data
public class TestResult {
    private Integer testId;
    private String title;
    private int blankScore;
    private int socre;
    private int count;
    private  int status;
    private String other;

    private List<Question> choiceQuestios;

    private List<Question> choicesQuestios;


}
