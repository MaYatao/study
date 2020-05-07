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

import java.util.List;

@Controller
@RequestMapping("search")
public class SeachController {

    @Autowired
    private SeachService seachService;

    @RequestMapping(value = "/get")
    @ResponseBody
    public AIResult getSeach(String content,Integer userId) {
        try {
            List<SearchParam> searchParamList = seachService.queryByUserName(content);
            return AIResult.ok(searchParamList);
        } catch (Exception e) {

            return AIResult.build(500, e.getMessage());
        }

    }

}
