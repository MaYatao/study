package com.tao.course.service.impl;


import com.tao.course.bean.Subject;
import com.tao.course.pojo.SubjectResult;
import com.tao.course.mapper.SubjectMapper;
import com.tao.course.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/11/7 16:48
 **/
@Service
public class SubjectServiceImpl  implements SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public List<SubjectResult> getSubject() {
        Example example=new Example(Subject.class);
        Example.Criteria criteria=example.createCriteria();
        example.orderBy("subjectId");
        criteria.andIsNull("parentId");
        List<Subject> subjects=subjectMapper.selectByExample(example);
        List<SubjectResult> subjectResults=new ArrayList<>();
        for(Subject s:subjects){
            SubjectResult subjectResult=new SubjectResult();
            subjectResult.setLabel(s.getTitle());
            subjectResult.setValue(s.getSubjectId());
            Example example1=new Example(Subject.class);
            Example.Criteria criteria1=example1.createCriteria();
            example1.orderBy("subjectId");
            criteria1.andEqualTo("parentId",s.getSubjectId());
            List<Subject> subjects1=subjectMapper.selectByExample(example1);
            List<SubjectResult> subjectResults1=new ArrayList<>();
            for (Subject s1:subjects1) {
                SubjectResult subjectResult1=new SubjectResult();
                subjectResult1.setLabel(s1.getTitle());
                subjectResult1.setValue(s1.getSubjectId());
                subjectResults1.add(subjectResult1);
            }
            subjectResult.setChildren(subjectResults1);
            subjectResults.add(subjectResult);
        }
        return subjectResults;
    }
}
