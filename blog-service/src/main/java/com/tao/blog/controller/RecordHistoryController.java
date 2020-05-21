package com.tao.blog.controller;

import com.tao.blog.bean.RecordHistory;
import com.tao.blog.service.RecordHistoryService;
import com.tao.common.utils.AIResult;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/11/7 16:55
 **/
@Controller
public class RecordHistoryController {

    @Autowired
    private RecordHistoryService  RecordHistoryService;
    //使用RabbitTemplate,这提供了接收/发送等等方法
    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 添加文章访问量
     **/
    @RequestMapping(value = "/addViews", method = RequestMethod.POST)
    @ResponseBody
    public AIResult addViews(RecordHistory recordHistory) {  //根据用户id查询不同状态的文章
        try {
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = formatter.format(currentTime);
            recordHistory.setViewTime(dateString);
             RecordHistoryService.addViews(recordHistory);
             return AIResult.ok();
        } catch (Exception e) {
            return AIResult.build(500, e.getMessage());
        }
    }
    /**
     * 添加文章访问量
     **/
    @RequestMapping(value = "/addAggree", method = RequestMethod.POST)
    @ResponseBody
    public AIResult addAggree(RecordHistory recordHistory) {  //根据用户id查询不同状态的文章
        try {
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = formatter.format(currentTime);
            recordHistory.setAggreeTime(dateString);
            RecordHistoryService.addAggre(recordHistory);
            Map<String,Object> map=new HashMap<>();
            map.put("fromUser",recordHistory.getFromUser())   ;
            map.put("toUser",recordHistory.getToUser());
            map.put("sentTime",recordHistory.getCommentTime());
            map.put("title","对为你点赞");
            map.put("contentId",recordHistory.getContentId());
            map.put("type",0);
            rabbitTemplate.convertAndSend("message.aggree.queue",map);
            return AIResult.ok();
        } catch (Exception e) {
            return AIResult.build(500, e.getMessage());
        }
    }

}
