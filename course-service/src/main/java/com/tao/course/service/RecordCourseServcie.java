package com.tao.course.service;

import com.tao.course.bean.RecordCourse;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 22:41
 **/
public interface RecordCourseServcie {
    void save(RecordCourse recordCourse);

    void edit(RecordCourse recordCourse);

    RecordCourse getRC(Integer courseId, Integer userId);
}
