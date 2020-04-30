package com.tao.course.service.impl;

import com.tao.course.mapper.RecordCoursesMapper;
import com.tao.course.service.RecordCourseServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 23:04
 **/
@Service
public class RecordCourseServiceImpl  implements RecordCourseServcie {

    @Autowired
    private RecordCoursesMapper recordCoursesMapper;

}
