package com.tao.question.service;

import com.github.pagehelper.PageInfo;
import com.tao.question.bean.Question;

import java.util.List;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 22:46
 **/
public interface QuestionService {
    void save(Question question);

    void edit(Question question);

   PageInfo<Question> getQuestionsBySid(Integer subject, Integer status, Integer page, Integer row);

    void getQuestionsById(Integer quertionId);

    void deleteByQid(Integer quertionId);

    void deleteByUid(Integer userId);

    List<Question> searchQuestion(Question question);
}
