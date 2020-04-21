package com.tao.course.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author tao
 * @Description 课程记录表
 * @date 2019/10/29 19:22
 **/
@Entity
@Table(name="tb_record_course")
@Data
public class RecordCourse {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private   Integer  rcid;
    private   Integer  userId;
    private   Integer   courseId;//课程名

    private   String  totleTime;//学习总时间

}
