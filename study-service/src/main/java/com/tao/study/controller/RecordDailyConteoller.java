package com.tao.study.controller;


import com.tao.study.service.RecordDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 23:09
 **/
@Controller
@RequestMapping("recordDaily")
public class RecordDailyConteoller {
    @Autowired
    private RecordDailyService recordDailyService;
}
