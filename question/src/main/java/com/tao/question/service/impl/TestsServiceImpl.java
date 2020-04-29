package com.tao.question.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tao.question.bean.Question;
import com.tao.question.bean.TestResult;
import com.tao.question.bean.Tests;
import com.tao.question.mapper.QuestionsMapper;
import com.tao.question.mapper.TestsMapper;
import com.tao.question.service.TestsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 22:53
 **/
@Service
public class TestsServiceImpl implements TestsService {
    @Autowired
    private TestsMapper testsMapper;
    @Autowired
    private QuestionsMapper questionsMapper;

    @Override
    public void deleteTestByTid(Integer testId) {

    }

    @Override
    public void deleteTestByUid(Integer userId) {

    }

    @Override
    public TestResult getTestByTid(Integer testId) {
        Tests tests=testsMapper.selectByPrimaryKey(testId);
        TestResult testResult = new TestResult();
        testResult.setCount(tests.getCount());
        testResult.setStatus(tests.getStatus());
        testResult.setOther(tests.getOther());
        testResult.setTestId(tests.getTestId());
        testResult.setTitle(tests.getTitle());
        testResult.setChoiceQuestios(new ArrayList<>());
        testResult.setChoicesQuestios(new ArrayList<>());
        String[] choice = tests.getChoiceQuestios().split(",");
        String[] choices = tests.getChoicesQuestios().split(",");
     /*   String[] content = tests.getContentQuestios().split(",");*/
        for (String s : choice) {
            if (!s.isEmpty()) {
                int qId = Integer.valueOf(s);
                testResult.getChoiceQuestios().add(questionsMapper.selectByPrimaryKey(qId));
            }
        }
        for (String s : choices) {
            if (!s.isEmpty()) {
                int qId = Integer.valueOf(s);
                testResult.getChoicesQuestios().add(questionsMapper.selectByPrimaryKey(qId));
            }
        }
        return testResult;
    }

    @Override
    public void getTestByUid(Integer userId) {

    }

    @Override
    public PageInfo<TestResult> getHotTestList(Integer page, Integer row) {
        List<Tests> testsList = new ArrayList<>();
        Example example = new Example(Tests.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("type",1);
        example.orderBy("views");
        testsList = testsMapper.selectByExample(example);
        List<TestResult> resultList = new ArrayList<>();
        for (Tests tests : testsList) {
            TestResult testResult = new TestResult();
            testResult.setCount(tests.getCount());
            testResult.setStatus(tests.getStatus());
            testResult.setOther(tests.getOther());
            testResult.setTestId(tests.getTestId());
            testResult.setTitle(tests.getTitle());
            testResult.setChoiceQuestios(new ArrayList<>());
            testResult.setChoicesQuestios(new ArrayList<>());

            String[] choice = tests.getChoiceQuestios().split(",");
            String[] choices = tests.getChoicesQuestios().split(",");

            for (String s : choice) {
                if (!s.isEmpty()) {
                    int qId = Integer.valueOf(s);
                    testResult.getChoiceQuestios().add(questionsMapper.selectByPrimaryKey(qId));
                }
            }
            for (String s : choices) {
                if (!s.isEmpty()) {
                    int qId = Integer.valueOf(s);
                    testResult.getChoicesQuestios().add(questionsMapper.selectByPrimaryKey(qId));
                }
            }
                      resultList.add(testResult);
        }
        PageHelper.startPage(page, row);
        PageInfo<TestResult> pages = new PageInfo<TestResult>(resultList);
        return pages;
    }

    @Override
    public PageInfo<TestResult> getLastTestList(Integer page, Integer row) {
        List<Tests> testsList = new ArrayList<>();
        Example example = new Example(Tests.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("type",1);
        example.orderBy("createTime");
        testsList = testsMapper.selectByExample(example);
        List<TestResult> resultList = new ArrayList<>();
        for (Tests tests : testsList) {
            TestResult testResult = new TestResult();
            testResult.setCount(tests.getCount());
            testResult.setStatus(tests.getStatus());
            testResult.setOther(tests.getOther());
            testResult.setTestId(tests.getTestId());
            testResult.setTitle(tests.getTitle());
            testResult.setChoiceQuestios(new ArrayList<>());
            testResult.setChoicesQuestios(new ArrayList<>());
                String[] choice = tests.getChoiceQuestios().split(",");
            String[] choices = tests.getChoicesQuestios().split(",");
                    for (String s : choice) {
                if (!s.isEmpty()) {
                    int qId = Integer.valueOf(s);
                    testResult.getChoiceQuestios().add(questionsMapper.selectByPrimaryKey(qId));
                }
            }
            for (String s : choices) {
                if (!s.isEmpty()) {
                    int qId = Integer.valueOf(s);
                    testResult.getChoicesQuestios().add(questionsMapper.selectByPrimaryKey(qId));
                }
            }
                  resultList.add(testResult);
        }
        PageHelper.startPage(page, row);
        PageInfo<TestResult> pages = new PageInfo<TestResult>(resultList);
        return pages;
    }

    @Override
    public Integer createTestBySubject(String subjectIds, Integer num, Integer userId, Integer degree, String types) {

        String[] subjectList = subjectIds.split(",");
        String[] typeList = types.split(",");
        List<Integer> subjects = new ArrayList<>();
        List<Integer> typesList = new ArrayList<>();

        for (String s : subjectList) {
            if (!s.isEmpty()) {
                int subjectId = Integer.valueOf(s);
                subjects.add(subjectId);
            }
        }
        for (String s : typeList) {
            if (!s.isEmpty()) {
                int type = Integer.valueOf(s);
                typesList.add(type);
            }
        }

        List<Question> questionList =  questionsMapper.slectQuestionBySubject(subjects,typesList,degree,num);
        Tests tests = new Tests();
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        tests.setCreateTime(dateString);
        tests.setCount(questionList.size());
        tests.setStatus(degree);
        tests.setUserId(userId);
        tests.setTitle("专项练习");
        String choice = "";
        String choices = "";
        List choiceList=new ArrayList();
        List choicesList=new ArrayList();
        System.out.println(questionList);
        for (Question q : questionList) {
            if (q.getType() == 1 ) {
                choiceList.add(q.getQid());
            }
            if (q.getType() == 2 ) {
                choicesList.add(q.getQid());
            }
        }
        choice= StringUtils.join(choiceList.toArray(),",");
        choices= StringUtils.join(choicesList.toArray(),",");
        tests.setChoiceQuestios(choice);
        tests.setChoicesQuestios(choices);
        testsMapper.insert(tests);
        int testId=tests.getTestId();


        return testId;
    }

    @Override
    public void save(Tests tests) {
        testsMapper.insert(tests);
    }

    @Override
    public void edit(Tests tests) {
        testsMapper.updateByPrimaryKeySelective(tests);
    }
}
