package com.tao.course.controller;

import com.tao.common.utils.AIResult;
import com.tao.course.bean.Couerses;
import com.tao.course.bean.RecordCourse;
import com.tao.course.service.RecordCourseServcie;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    //开始学习
    @RequestMapping(value = "/createRC", method = RequestMethod.POST,produces="application/json")
    public AIResult saveUser(@RequestBody RecordCourse recordCourse) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        recordCourse.setLastTime(dateString);
        try {
                recordCourseServcie.save(recordCourse);
        } catch (Exception e) {
            return AIResult.build(500, e.getMessage());
        }
        return AIResult.ok("发布成功");
    }
    /**
    * 开始学习
    * */
    @RequestMapping(value = "/editRC", method = RequestMethod.POST,produces="application/json")
    public AIResult editUser(@RequestBody RecordCourse recordCourse) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        recordCourse.setLastTime(dateString);
        try {
            recordCourseServcie.edit(recordCourse);

        } catch (Exception e) {
            return AIResult.build(500, e.getMessage());
        }
        return AIResult.ok("发布成功");
    }

      @RequestMapping(value = "/getRC")
       public AIResult getRCBy(Integer  courseId,Integer userId) {
        try {
           RecordCourse recordCourse= recordCourseServcie.getRC(courseId,userId);

            return    AIResult.ok(recordCourse);
        } catch (Exception e) {
            e.printStackTrace();
            return AIResult.build(500, e.getMessage());
        }
    }

}
