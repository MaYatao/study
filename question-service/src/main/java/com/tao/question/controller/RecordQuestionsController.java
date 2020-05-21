package com.tao.question.controller;

import com.tao.common.utils.AIResult;
import com.tao.question.pojo.QuestionResult;
import com.tao.question.service.RecordQuertionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 23:11
 **/
@RestController
public class RecordQuestionsController {

    @Autowired
    private RecordQuertionsService  recordQuertionsService;

    @RequestMapping("/getQuestionsByUtid")
    public AIResult getQuestionsByUtid(Integer userId,Integer testId) {
        List<QuestionResult> questionResults = recordQuertionsService.getQuestionsByRtid(userId,testId);
        return AIResult.ok(questionResults);
    }


}
