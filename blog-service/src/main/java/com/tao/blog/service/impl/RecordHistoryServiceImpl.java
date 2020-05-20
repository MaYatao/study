package com.tao.blog.service.impl;


import com.tao.blog.bean.Content;
import com.tao.blog.bean.RecordHistory;
import com.tao.blog.mapper.ContentMapper;
import com.tao.blog.mapper.RecordHistoryMapper;
import com.tao.blog.service.RecordHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/11/7 16:53
 **/
@Service
public class RecordHistoryServiceImpl implements RecordHistoryService {


    @Autowired
    private RecordHistoryMapper recordHistoryMapper;
    @Autowired
    private ContentMapper contentMapper;

    @Override
    public void addViews(RecordHistory recordHistory) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);

        Content content = contentMapper.selectByPrimaryKey(recordHistory.getContentId());

        content.setViews(content.getViews() + 1);
        recordHistoryMapper.insert(recordHistory);
        contentMapper.updateByPrimaryKeySelective(content);
    }



    @Override
    public void addAggre(RecordHistory recordHistory) {

    }

    @Override
    public void addComment(RecordHistory recordHistory) {

    }

}
