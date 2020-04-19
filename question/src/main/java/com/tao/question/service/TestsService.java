package com.tao.question.service;

import com.github.pagehelper.PageInfo;
import com.tao.question.bean.TestResult;
import com.tao.question.bean.Tests;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 22:45
 **/
public interface TestsService {
    void deleteTestByTid(Integer testId);

    void deleteTestByUid(Integer userId);

    TestResult getTestByTid(Integer testId);

    void getTestByUid(Integer userId);


    void save(Tests tests);

    void edit(Tests tests);

    PageInfo<TestResult> getHotTestList(Integer page, Integer row);

    PageInfo<TestResult> getLastTestList(Integer page, Integer row);

    Integer createTestBySubject(String subjectIds, Integer num, Integer userId, Integer degree, String types);
}
