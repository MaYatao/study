package com.tao.course.service;

import com.tao.course.bean.Couerses;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: 麻亚涛
 * @Date: 2020/4/29 14:54
 */
public interface EsCourseService {
    public void addCouerses(Couerses couerses);
    public void deletedCouersesById(String id);
    public void updateCouerses(Couerses couerses) ;
    public List<Couerses> queryByTitle(String title) ;
}
