package com.tao.question.service.impl;

import com.github.pagehelper.PageInfo;
import com.tao.question.bean.Question;
import com.tao.question.mapper.QuestionsMapper;
import com.tao.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 22:53
 **/
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionsMapper questionsMapper;

    @Override
    public void save(Question question) {
        questionsMapper.insert(question);
    }

    @Override
    public void edit(Question question) {
     questionsMapper.updateByPrimaryKeySelective(question);
    }

    @Override
    public PageInfo<Question> getQuestionsBySid(Integer subject, Integer status, Integer page, Integer row) {
        return null;
    }

    @Override
    public void getQuestionsById(Integer quertionId) {

    }

    @Override
    public void deleteByQid(Integer quertionId) {

    }

    @Override
    public void deleteByUid(Integer userId) {

    }

    @Override
    public List<Question> searchQuestion(Question question) {
        System.out.println(question);
        Example example=new Example(Question.class);
        Example.Criteria criteria=example.createCriteria();
        if(question.getSubject()!=null){
            criteria.andEqualTo("subject",question.getSubject());
        }
        if(!question.getKnowledge().isEmpty()){
            criteria.andEqualTo("knowledge",question.getKnowledge());
        }
        if(question.getDegree()!=0 ){
            criteria.andEqualTo("degree",question.getDegree());
        }
        List<Question> questionList=questionsMapper.selectByExample(example);
        return questionList;
    }
}
