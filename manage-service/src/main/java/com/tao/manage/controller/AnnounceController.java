package com.tao.manage.controller;

import com.github.pagehelper.PageInfo;
import com.tao.common.utils.AIResult;
import com.tao.manage.bean.Announce;
import com.tao.manage.service.AnnounceService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AnnounceController {

    @Autowired
    private AnnounceService announceService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/createAnnounce", method = RequestMethod.POST,produces="application/json")
    public AIResult createAnnounce(@RequestBody Announce announce) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        announce.setSentTime(dateString);
        try {
                announceService.save(announce);
            Map<String,Object> map=new HashMap<>();
         //点赞转发者
            map.put("fromUser",-1)   ;
            map.put("title",announce.getTitle());
            map.put("toUser",announce.getToUser());
            map.put("sentTime",announce.getSentTime());
            map.put("content",announce.getContent());
            map.put("status",false);
            map.put("type",0);
            rabbitTemplate.convertAndSend("message.announce.queue",map);
        } catch (Exception e) {
            return AIResult.build(500, e.getMessage());
        }
        return AIResult.ok("发布成功");
    }
    @RequestMapping(value = "/getAnnounce")
    public AIResult getAnnounce(Integer page, Integer row) {
        try {
            PageInfo<Announce> announces = announceService.getAnnuouce( page,  row);
            return AIResult.ok(announces);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return AIResult.build(500, e.getMessage());
        }
    }

    @RequestMapping("/deleteAnnounceById")
    public AIResult deleteAnnounceById(Integer announceId) {
        announceService.deleteAnnounceById(announceId);
        return AIResult.ok();
    }

}
