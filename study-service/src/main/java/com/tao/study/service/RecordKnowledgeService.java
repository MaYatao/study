package com.tao.study.service;

import com.tao.study.bean.Knowledge;
import com.tao.study.bean.RecordKnowledge;

import java.util.List;

public interface RecordKnowledgeService {
    List<Knowledge> getMapByUId(Integer userId);

    void save(RecordKnowledge recordKnowledge);
}
