package com.tao.user.controller;

import com.tao.user.service.RecordSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 23:24
 **/
@Controller
@RequestMapping("message")
public class RecordSearchController {
    @Autowired
    private RecordSearchService recordSearchService;
}
