package com.tao.question.service;

import com.tao.question.bean.QuestionResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 22:43
 **/
@Service
public interface RecordQuertionsService {
    Map<String, Integer> saveQuestions(Map<String, Object> map);

    List<QuestionResult> getQuestionsByRtid(Integer userId, Integer rtid);
}
