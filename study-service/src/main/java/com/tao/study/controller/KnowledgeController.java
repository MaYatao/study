package com.tao.study.controller;

import com.tao.common.utils.AIResult;
import com.tao.study.bean.Knowledge;
import com.tao.study.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: 麻亚涛
 * @Date: 2020/4/21 15:35
 */
@RestController
public class KnowledgeController {
    @Autowired
    private KnowledgeService knowledgeService;
    @RequestMapping(value = "/getKnowledgesBySId")
    @ResponseBody
    public AIResult getSubject(Integer subjectId) {
        try {
            List<Knowledge> subjectResult = knowledgeService.getKnowledgesBySId(subjectId);
            return AIResult.ok(subjectResult);
        } catch (Exception e) {

            return AIResult.build(500, e.getMessage());
        }

    }
}
