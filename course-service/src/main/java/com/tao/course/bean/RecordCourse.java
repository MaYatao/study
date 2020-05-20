package com.tao.course.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author tao
 * @Description 课程记录表
 * @date 2019/10/29 19:22
 **/
@Entity
@Table(name="tb_course_record_")
@Data
public class RecordCourse {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private   Integer  rcid;
    private   Integer  userId;
    //课程名
    private   Integer  courseId;
    //学习总时间
    private   String  studyTime;

    //最后学习时间
    private   String  lastTime;
    //是否完成
    private  Boolean studyed;

}
