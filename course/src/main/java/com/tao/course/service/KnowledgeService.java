package com.tao.course.service;

import com.tao.course.bean.Knowledge;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: 麻亚涛
 * @Date: 2020/4/21 15:36
 */
public interface KnowledgeService {
    List<Knowledge> getKnowledgesBySId(Integer subjectId);
}
