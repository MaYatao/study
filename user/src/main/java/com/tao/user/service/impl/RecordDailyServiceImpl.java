package com.tao.user.service.impl;

import com.tao.user.mapper.RecordDailyMapper;
import com.tao.user.service.RecordDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 23:04
 **/
@Service
public class RecordDailyServiceImpl implements RecordDailyService {

    @Autowired
    private RecordDailyMapper recordDailyMapper;

}
