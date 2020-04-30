package com.tao.blog.controller;

import com.tao.blog.bean.RecordHistory;
import com.tao.blog.service.RecordHistoryService;
import com.tao.common.utils.AIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/11/7 16:55
 **/
@Controller
public class RecordHistoryController {

    @Autowired
    private RecordHistoryService  RecordHistoryService;


    @RequestMapping(value = "/addViews", method = RequestMethod.POST)
    @ResponseBody
    public AIResult addViews(RecordHistory recordHistory) {  //根据用户id查询不同状态的文章
        try {
             RecordHistoryService.addViews(recordHistory);
             return AIResult.ok();
        } catch (Exception e) {
            return AIResult.build(500, e.getMessage());
        }
    }

    @RequestMapping(value = "/addCollection", method = RequestMethod.POST)
    @ResponseBody
    public AIResult addCollection(RecordHistory recordHistory) {  //根据用户id查询不同状态的文章
        try {
            RecordHistoryService.addCollection(recordHistory);

            return AIResult.ok();
        } catch (Exception e) {
            return AIResult.build(500, e.getMessage());
        }
    }

}
