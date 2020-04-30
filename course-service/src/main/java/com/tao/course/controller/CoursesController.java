package com.tao.course.controller;


import com.tao.common.utils.AIResult;
import com.tao.course.bean.Couerses;
import com.tao.course.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 22:47
 **/
@RestController
public class CoursesController {

    @Autowired
    private CoursesService coursesService;
    @RequestMapping(value = "/createOrEditCourse", method = RequestMethod.POST,produces="application/json")
    public AIResult saveUser(@RequestBody Couerses couerses) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        couerses.setCreateTime(dateString);
        try {
            if(couerses.getCourseId()==null){
                coursesService.save(couerses);
            }else{
                coursesService.edit(couerses);
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


}
