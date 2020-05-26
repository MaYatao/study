package com.tao.study.service;

import com.tao.study.bean.Knowledge;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: 麻亚涛
 * @Date: 2020/4/21 15:36
 */
public interface KnowledgeService {
    List<Knowledge> getKnowledgeBySId(Integer subjectId);
}
