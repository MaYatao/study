package com.tao.question.controller;

import com.tao.common.utils.AIResult;
import com.tao.question.bean.Question;
import com.tao.question.bean.RecordTests;
import com.tao.question.service.RecordQuertionsService;
import com.tao.question.service.RecordTestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 23:12
 **/


@RestController
public class RecordTestsController    {
    @Autowired
    private  RecordTestsService  recordTestsService;
    @Autowired
    private RecordQuertionsService recordQuertionsService;
    @RequestMapping(value = "/createRecordTest", method = RequestMethod.POST, produces = "application/json")
    public AIResult saveUser(@RequestBody Map<String,Object> map) {
        try {
            List<Question> questionList = (List<Question>) map.get("questionList");
            Integer testId = (Integer) map.get("testId");
            Integer userId= (Integer) map.get("userId");
            Integer status= (Integer) map.get("status");
            String title= (String) map.get("title");
            String spendTime= (String) map.get("spendTime");
            RecordTests recordTests =new RecordTests();
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = formatter.format(currentTime);
            recordTests.setDate(dateString);
            recordTests.setTestId(testId);
            recordTests.setSpendTime(spendTime);
            recordTests.setUserId(userId);
            recordTests.setStstus(status);
            recordTests.setTotalNum(questionList.size());
            recordTests.setTitle(title);
           Map<String, Integer> result= recordQuertionsService.saveQuestions(map);
           recordTests.setTotalScore(result.get("totalScore"));
           recordTests.setTrueNum(result.get("trueNum"));
            int rtid=  recordTestsService.save(recordTests);
            return AIResult.ok(rtid);
        /*    recordTestsService.save(tests);*/
        } catch (Exception e) {
            e.printStackTrace();
            return AIResult.build(500, e.getMessage());
        }
    }

    @RequestMapping("/getRecordTestById")
    public AIResult getRecordTestById(Integer rtid) {
        RecordTests recordTests = recordTestsService.getRecordTestById(rtid);
        return AIResult.ok(recordTests);
    }
}
