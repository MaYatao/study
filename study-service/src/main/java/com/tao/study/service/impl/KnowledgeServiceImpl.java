package com.tao.study.service.impl;


import com.tao.study.bean.Knowledge;
import com.tao.study.mapper.KnowledgeMapper;
import com.tao.study.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: 麻亚涛
 * @Date: 2020/4/21 15:36
 */
@Service
public class KnowledgeServiceImpl  implements KnowledgeService {
    @Autowired
    private KnowledgeMapper knowledgeMapper;

    @Override
    public List<Knowledge> getKnowledgesBySId(Integer subjectId) {
        Example example=new Example(Knowledge.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("subjectId",subjectId);
        List<Knowledge> knowledgeList=knowledgeMapper.selectByExample(example);
        return knowledgeList;
    }
}
