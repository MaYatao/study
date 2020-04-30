package com.tao.study.controller;


import com.tao.common.utils.AIResult;
import com.tao.study.pojo.SubjectResult;
import com.tao.study.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/11/7 16:50
 **/
@Controller
public class SubjectController {

    @Autowired
    private SubjectService SubjectService;

    @RequestMapping(value = "/getSubjects")
    @ResponseBody
    public AIResult getSubject() {
        try {
        List<SubjectResult> subjectResult = SubjectService.getSubject();
            return AIResult.ok(subjectResult);
        } catch (Exception e) {

            return AIResult.build(500, e.getMessage());
        }

    }

}
