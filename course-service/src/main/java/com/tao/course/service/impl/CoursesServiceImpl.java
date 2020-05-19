package com.tao.course.service.impl;


import com.tao.course.bean.Couerses;
import com.tao.course.mapper.CoursesMapper;
import com.tao.course.service.CoursesService;
import com.tao.study.bean.RecordKnowledge;
import com.tao.study.mapper.RecordKnowledgeMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 22:54
 **/
@Service
public class CoursesServiceImpl implements CoursesService {
    @Autowired
    private CoursesMapper coursesMapper;
    @Autowired
    private RecordKnowledgeMapper recordKnowledgeMapper;

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
        Example example = new Example(Couerses.class);
        Example.Criteria criteria = example.createCriteria();
        if (couerses.getSubject() != -1) {
            criteria.andEqualTo("subject", couerses.getSubject());
        }
        if (couerses.getDegree() != -1) {
            criteria.andEqualTo("degree", couerses.getSubject());
        }
        if (couerses.getDirection() != -1) {
            criteria.andEqualTo("direction", couerses.getSubject());
        }
        List<Couerses> commentResults = coursesMapper.selectByExample(example);
        return commentResults;
    }

    @Override
    public Couerses getCourseById(Integer couerseId) {

        return coursesMapper.selectByPrimaryKey(couerseId);
    }

    //根据结点推荐课程
    @Override
    public List<Couerses> recommendCourse(Integer userId) {
        Example example = new Example(RecordKnowledge.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", userId);
        example.orderBy("rkid");
        RowBounds rowBounds = new RowBounds(1, 10);
        List<RecordKnowledge> recordKnowledges = recordKnowledgeMapper.selectByExampleAndRowBounds(example, rowBounds);
        Example example1 = new Example(RecordKnowledge.class);
        Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andIn("knowledges1", recordKnowledges);
        criteria1.andIn("knowledges2", recordKnowledges);
        criteria1.andIn("knowledges3", recordKnowledges);
        return coursesMapper.selectByExample(example1);
    }

}
