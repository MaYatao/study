package com.tao.study.controller;

import com.tao.common.utils.AIResult;
import com.tao.study.es.SeachService;
import com.tao.study.es.SearchParam;
import com.tao.study.pojo.SubjectResult;
import com.tao.study.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
public class SeachController {

    @Autowired
    private SeachService seachService;
    
    @RequestMapping(value = "/search")
    @ResponseBody
    public AIResult getSeach(String content) {
        try {
            List<SearchParam> searchParamList = seachService.queryByName(content);
            return AIResult.ok(searchParamList);
        } catch (Exception e) { e.printStackTrace();
            return AIResult.build(500, e.getMessage());
        }

    }
}
