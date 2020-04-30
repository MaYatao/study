package com.tao.course.service;

import com.tao.course.bean.Couerses;

import java.util.List;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 22:45
 **/
public interface CoursesService {
  public   void save(Couerses couerses);
  public  void  edit(Couerses couerses);

    List<Couerses> getCoursesByType(Couerses couerses);

  Couerses getCourseById(Integer couerseId);
}
