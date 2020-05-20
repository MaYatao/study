package com.tao.course.service.impl;

import com.tao.course.bean.RecordCourse;
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

    @Override
    public void save(RecordCourse recordCourse) {
        recordCoursesMapper.insert(recordCourse);
    }

    @Override
    public void edit(RecordCourse recordCourse) {
      recordCoursesMapper.updateByPrimaryKeySelective(recordCourse);
    }

    @Override
    public RecordCourse getRC(Integer courseId, Integer userId) {
        RecordCourse recordCourse =new RecordCourse();
        recordCourse.setCourseId(courseId);
        recordCourse.setUserId(userId);

        return recordCoursesMapper.selectOne(recordCourse);
    }
}
