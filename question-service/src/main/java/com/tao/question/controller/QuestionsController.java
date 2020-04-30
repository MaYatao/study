package com.tao.question.controller;

import com.tao.common.utils.AIResult;
import com.tao.question.bean.Question;
import com.tao.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 22:49
 **/
@Controller
public class QuestionsController {
    @Autowired
    private QuestionService questionService;
    @RequestMapping(value = "/createOrEditQuestion", method = RequestMethod.POST,produces="application/json")
    @ResponseBody
    public AIResult saveUser(@RequestBody Question question) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
       question.setCreateTime(dateString);
        try {
            if(question.getQid()==null){
                questionService.save(question);
            }else{
                questionService.edit(question);
            }

        } catch (Exception e) {
            return AIResult.build(500, e.getMessage());
        }
        return AIResult.ok("发布成功");
    }

    @RequestMapping(value = "/getQuestionsBySid")
    @ResponseBody
    public AIResult getQuestionsBySid(Integer subject, Integer status,Integer page, Integer row) {  //根据用户id查询不同状态的文章
        try {
           questionService.getQuestionsBySid(subject, status ,page,  row);
            return AIResult.ok();
        } catch (Exception e) {
            return AIResult.build(500, e.getMessage());
        }
    }
    @RequestMapping(value = "/getQuestionsById")
    @ResponseBody
    public AIResult getQuestionsById(Integer quertionId) {
        try {

            questionService.getQuestionsById(quertionId);

            return AIResult.ok();
        } catch (Exception e) {
            return AIResult.build(500, e.getMessage());
        }
    }

    @RequestMapping(value = "/searchQuestion")
    @ResponseBody
    public AIResult searchQuestion(Question question) {
        try {

         List<Question> questionList= questionService.searchQuestion(question);

            return AIResult.ok(questionList);
        } catch (Exception e) {
            return AIResult.build(500, e.getMessage());
        }
    }

    @RequestMapping(value = "/deleteByQid")
    @ResponseBody
    public AIResult deleteByQid(Integer quertionId) {

        try {
            questionService.deleteByQid(quertionId);
            return AIResult.ok("删除成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return AIResult.build(500, e.getMessage());

        }
    }
    @RequestMapping(value = "/deleteByUid")
    @ResponseBody
    public AIResult deleteByUid(Integer userId) {

        try {
            questionService.deleteByUid(userId);
            return AIResult.ok("删除成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return AIResult.build(500, e.getMessage());

        }
    }
}
