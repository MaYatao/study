package com.tao.study.service.impl;

import com.tao.study.bean.Knowledge;
import com.tao.study.bean.RecordKnowledge;
import com.tao.study.mapper.RecordKnowledgeMapper;
import com.tao.study.service.RecordKnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordKnowledgeServiceImpl  implements RecordKnowledgeService {

    @Autowired
    private RecordKnowledgeMapper recordKnowledgeMapper;
    @Override
    public List<Knowledge> getMapByUId(Integer userId) {
        return null;
    }

    @Override
    public void save(RecordKnowledge recordKnowledge) {
        recordKnowledgeMapper.insert(recordKnowledge);
    }
}
