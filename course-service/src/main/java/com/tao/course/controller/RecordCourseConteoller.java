package com.tao.course.controller;

import com.tao.course.service.RecordCourseServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 23:09
 **/
@Controller
@RequestMapping("recordCourse")
public class RecordCourseConteoller   {
    @Autowired
    private RecordCourseServcie  recordCourseServcie;
}
