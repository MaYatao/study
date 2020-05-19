package com.tao.study.controller;

import com.tao.common.utils.AIResult;
import com.tao.study.bean.Knowledge;
import com.tao.study.bean.RecordKnowledge;
import com.tao.study.service.KnowledgeService;
import com.tao.study.service.RecordKnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecordKnowledgeController {

    @Autowired
    private RecordKnowledgeService recordKnowledgeService;

    @RequestMapping(value = "/getMapByUId")
    @ResponseBody
    public AIResult getSubject(Integer userId) {
        try {
            List<Knowledge> mapResult = recordKnowledgeService.getMapByUId(userId);
            return AIResult.ok(mapResult);
        } catch (Exception e) {
            return AIResult.build(500, e.getMessage());
        }
    }

    @RequestMapping(value = "/addKnowledgesByQid")
    @ResponseBody
    public AIResult addKnowledgesByQuestions(Integer userId, List<Integer> kids) {
        for (Integer kid : kids) {
            RecordKnowledge recordKnowledge = new RecordKnowledge();
            recordKnowledge.setUserId(userId);
            recordKnowledge.setKnowledgeId(kid);
            recordKnowledgeService.save(recordKnowledge);
        }
        return AIResult.ok();
    }

}
