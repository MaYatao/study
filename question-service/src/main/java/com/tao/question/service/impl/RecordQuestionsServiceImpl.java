package com.tao.question.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tao.question.bean.Question;
import com.tao.question.pojo.QuestionResult;
import com.tao.question.pojo.RecordQuestions;
import com.tao.question.mapper.QuestionsMapper;
import com.tao.question.mapper.RecordQuestionsMapper;
import com.tao.question.service.RecordQuertionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 23:06
 **/
@Service
public class RecordQuestionsServiceImpl  implements RecordQuertionsService {

    @Autowired
    private RecordQuestionsMapper  recordQuestionsMapper;
    @Autowired
    private QuestionsMapper questionsMapper;

    @Override
    public Map<String, Integer> saveQuestions(Map<String,Object>  map) {
        int trueNum=0;
        int totalScore=0;
        Integer testId= (Integer) map.get("testId");
        Integer userId= (Integer) map.get("userId");
       //map中的List如何转化
        String listTxt = JSONArray.toJSONString(map.get("questionList"));
        List<Question> questionList=JSONObject.parseArray (listTxt,Question.class);
        System.out.println(questionList);

        for (Question question: questionList) {
            Question q=questionsMapper.selectByPrimaryKey(question.getQid());
            RecordQuestions recordQuestions=new RecordQuestions();
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = formatter.format(currentTime);
            recordQuestions.setDateTime(dateString);
            recordQuestions.setQusertionId(question.getQid());
            recordQuestions.setUserId(userId);
            recordQuestions.setUserAnswer(question.getAnswer());
            recordQuestions.setTestId(testId);
            if(q.getAnswer().equals(question)){
                recordQuestions.setError(false);
                recordQuestions.setScore(question.getScore());
                totalScore+=question.getScore();
                trueNum++;
            }else{
                recordQuestions.setError(true);
                recordQuestions.setScore(0);
            }
            recordQuestionsMapper.insert(recordQuestions);
        }
        Map<String,Integer> result=new HashMap<>();
        result.put("trueNum",trueNum);
        result.put("totalScore",totalScore);
        return result;
    }

    @Override
    public List<QuestionResult> getQuestionsByRtid(Integer userId, Integer testId) {
        Example example=new Example(RecordQuestions.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("userId",userId);
        criteria.andEqualTo("testId",testId);
        List<RecordQuestions> recordQuestions=recordQuestionsMapper.selectByExample(example);
        List<QuestionResult> questionResults=new ArrayList<>();
        for (RecordQuestions rq:recordQuestions) {
            QuestionResult questionResult=new QuestionResult();
            Question question=questionsMapper.selectByPrimaryKey(rq.getQusertionId());
            questionResult.setAnalysis(question.getAnalysis());
            questionResult.setAnswer(question.getAnswer());
            questionResult.setContent(question.getContent());
            questionResult.setDegree(question.getDegree());
            questionResult.setKnowledge(question.getKnowledge());
            questionResult.setOptions(question.getOptions());
            questionResult.setType(question.getType());
            questionResult.setTestId(rq.getTestId());
            questionResult.setUserAnswer(rq.getUserAnswer());
            questionResult.setUserId(rq.getUserId());
            questionResult.setError(rq.getError());
            questionResult.setQid(rq.getQusertionId());
            questionResults.add(questionResult);
        }
        return questionResults;
    }
}
