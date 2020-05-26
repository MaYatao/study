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

    @RequestMapping(value = "/add")
    @ResponseBody
    public AIResult addSeach() {
        try {
            SearchParam searchParam=new SearchParam();
            searchParam.setBasics("O基础");
            searchParam.setContent("Java是最好的语言");

            searchParam.setDescription("hhahsd表达方式能尽快流芳百世的距离发表了多少");
            searchParam.setId("000"+new Random(100));
            searchParam.setTitle("Java");
            searchParam.setType(new Random(3).nextInt());
            seachService.add(searchParam);

            return AIResult.ok();
        } catch (Exception e) { e.printStackTrace();
            return AIResult.build(500, e.getMessage());
        }

    }
    @RequestMapping(value = "/get")
    @ResponseBody
    public AIResult getSeach() {
        try {
            List<SearchParam> searchParamList = seachService.queryByName("Java");
            return AIResult.ok(searchParamList);
        } catch (Exception e) { e.printStackTrace();
            return AIResult.build(500, e.getMessage());
        }

    }
}
