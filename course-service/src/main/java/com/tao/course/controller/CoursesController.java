package com.tao.course.controller;


import com.tao.common.utils.AIResult;
import com.tao.course.bean.Couerses;
import com.tao.course.pojo.CourseResult;
import com.tao.course.service.CoursesService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 22:47
 **/
@RestController
public class CoursesController {

    @Autowired
    private CoursesService coursesService;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @RequestMapping(value = "/createOrEditCourse", method = RequestMethod.POST,produces="application/json")
    public AIResult saveUser(@RequestBody Couerses couerses) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        couerses.setCreateTime(dateString);
        try {
            if(couerses.getCourseId()==null){
                coursesService.save(couerses);
                Map<String,Object> map=new HashMap<>();
                Couerses course= coursesService.getCourseById(couerses.getCourseId());
                map.put("title",course.getTitle());
                map.put("description",course.getDescription());
                map.put("id",course.getCourseId());
                map.put("createTime",couerses.getCreateTime());
                map.put("goal",couerses.getGoal());
                map.put("imageUrl",couerses.getImageUrl());
                map.put("userId",course.getUserId());
                map.put("username",course.getUsername());
                map.put("type",1);
                rabbitTemplate.convertAndSend("es.save.queue",map);
            }else{
                coursesService.edit(couerses);
                Map<String,Object> map=new HashMap<>();
                Couerses course= coursesService.getCourseById(couerses.getCourseId());
                map.put("title",course.getTitle());
                map.put("description",course.getDescription());
                map.put("id",course.getCourseId());
                map.put("createTime",couerses.getCreateTime());
                map.put("goal",couerses.getGoal());
                map.put("imageUrl",couerses.getImageUrl());
                map.put("userId",course.getUserId());
                map.put("username",course.getUsername());
                map.put("type",1);
                rabbitTemplate.convertAndSend("es.update.queue",map);
            }
        } catch (Exception e) {
            return AIResult.build(500, e.getMessage());
        }
        return AIResult.ok("发布成功");
    }



    @RequestMapping(value = "/getCoursesByType")
    @ResponseBody
    public AIResult getCoursesByType(Couerses couerses) {
        try {
        List<Couerses> coursesList= coursesService.getCoursesByType(couerses);
         return    AIResult.ok(coursesList);
        } catch (Exception e) {
            e.printStackTrace();
            return AIResult.build(500, e.getMessage());
        }
    }
    @RequestMapping(value = "/getCourseById")
    public AIResult getCourseById(Integer  courseId) {
        try {
            Couerses course= coursesService.getCourseById(courseId);
            return    AIResult.ok(course);
        } catch (Exception e) {
            e.printStackTrace();
            return AIResult.build(500, e.getMessage());
        }
    }

    @RequestMapping(value = "/recommendCourse")
    public AIResult recommendCourse(Integer userId) {
        try {
           List<Couerses>  course= coursesService.recommendCourse(userId);
            return    AIResult.ok(course);
        } catch (Exception e) {
            e.printStackTrace();
            return AIResult.build(500, e.getMessage());
        }
    }

}
