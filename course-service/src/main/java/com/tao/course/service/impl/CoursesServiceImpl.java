package com.tao.course.service.impl;


import com.tao.course.bean.Couerses;
import com.tao.course.mapper.CoursesMapper;
import com.tao.course.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 22:54
 **/
@Service
public class CoursesServiceImpl  implements CoursesService {
    @Autowired
    private CoursesMapper coursesMapper;

    @Override
    public void save(Couerses couerses) {
        coursesMapper.insert(couerses);
    }

    @Override
    public void edit(Couerses couerses) {
   coursesMapper.updateByPrimaryKeySelective(couerses);
    }

    @Override
    public List<Couerses> getCoursesByType(Couerses couerses) {
        Example example=new Example(Couerses.class);
        Example.Criteria criteria = example.createCriteria();
        if(couerses.getSubject()!=-1) {
            criteria.andEqualTo("subject", couerses.getSubject());
        }
        if(couerses.getDegree()!=-1) {
            criteria.andEqualTo("degree", couerses.getSubject());
        }
        if(couerses.getDirection()!=-1) {
            criteria.andEqualTo("direction", couerses.getSubject());
        }
        List<Couerses> commentResults =  coursesMapper.selectByExample(example);
        return commentResults;
    }

    @Override
    public Couerses getCourseById(Integer couerseId) {

        return coursesMapper.selectByPrimaryKey(couerseId);
    }

}
