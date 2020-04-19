package com.tao.question.service;

import com.tao.question.bean.RecordTests;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 22:43
 **/
public interface RecordTestsService {
    int save(RecordTests recordTests);

    RecordTests getRecordTestById(Integer rtid);
}
