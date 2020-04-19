package com.tao.question.service.impl;

import com.tao.question.bean.RecordTests;
import com.tao.question.mapper.RecordTestsMapper;
import com.tao.question.service.RecordTestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 23:07
 **/
@Service
public class RescordTestsServiceImpl  implements RecordTestsService {


    @Autowired
    private RecordTestsMapper  recordTestsMapper;

    @Override
    public int save(RecordTests recordTests) {
        recordTestsMapper.insert(recordTests);
        int rtId=recordTests.getRtid();
        return  rtId;
    }

    @Override
    public RecordTests getRecordTestById(Integer rtid) {
        return recordTestsMapper.selectByPrimaryKey(rtid);
    }
}
