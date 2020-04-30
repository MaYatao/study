package com.tao.question.controller;

import com.github.pagehelper.PageInfo;
import com.tao.common.utils.AIResult;
import com.tao.question.pojo.TestResult;
import com.tao.question.bean.Tests;
import com.tao.question.service.TestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 22:48
 **/
@RestController
public class TestsController {

    @Autowired
    private TestsService testsService;

    @RequestMapping(value = "/createOrEditTest", method = RequestMethod.POST, produces = "application/json")
    public AIResult saveUser(@RequestBody Tests tests) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        tests.setCreateTime(dateString);
        try {
            if (tests.getTestId() == null) {
                testsService.save(tests);
            } else {
                testsService.edit(tests);
            }
        } catch (Exception e) {
            return AIResult.build(500, e.getMessage());
        }
        return AIResult.ok("发布成功");
    }

    @RequestMapping(value = "/createTestBySubject", method = RequestMethod.POST)
    public AIResult createTestBySubject(String subjectIds,int num,int userId,int degree,String types) {
        try {
            Integer testId = testsService.createTestBySubject(subjectIds, num, userId, degree, types);
           return AIResult.ok(testId);
        } catch (Exception e) {
            return AIResult.build(500, e.getMessage());
        }
    }

    @RequestMapping("/getLastTestList")
    public AIResult getLastTestList(Integer page, Integer row) {
        PageInfo<TestResult> resultPageInfo = testsService.getLastTestList(page, row);
        return AIResult.ok(resultPageInfo);
    }

    @RequestMapping("/getHotTestList")
    public AIResult getHotTestList(Integer page, Integer row) {
        PageInfo<TestResult> resultPageInfo = testsService.getHotTestList(page, row);
        return AIResult.ok(resultPageInfo);
    }

    @RequestMapping("/getTestByUid")
    public AIResult getTestByUid(Integer userId) {
        testsService.getTestByUid(userId);
        return null;
    }

    @RequestMapping("/getTestByTid")
    public AIResult getTestByTid(Integer testId) {
        TestResult testResult = testsService.getTestByTid(testId);
        return AIResult.ok(testResult);
    }

    @RequestMapping("/deleteTestByUid")
    public AIResult deleteTestByUid(Integer userId) {
        testsService.deleteTestByUid(userId);
        return null;
    }

    @RequestMapping("deleteTestByTid")
    public AIResult deleteTestByTid(Integer testId) {
        testsService.deleteTestByTid(testId);
        return null;
    }

}
