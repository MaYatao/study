package com.tao.manage.controller;


import com.github.pagehelper.PageInfo;
import com.tao.common.utils.AIResult;
import com.tao.manage.bean.MessageResult;
import com.tao.manage.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 23:24
 **/
@RestController
public class MessageController {
    @Autowired
    private MessagesService messagesService;

    @RequestMapping(value = "/getMessageByUid")
    public AIResult getAnnounceByUid(Integer page, Integer row,Integer userId,Integer type) {
        try {
            PageInfo<MessageResult> imagePageInfo = messagesService.getMessageByUid( page,  row,userId,type);
            return AIResult.ok(imagePageInfo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return AIResult.build(500, e.getMessage());
        }
    }

    @RequestMapping("/deleteMessageById")
    public AIResult deleteMessageById(Integer messagesId) {
        messagesService.deleteMessageById(messagesId);
        return AIResult.ok("删除成功");
    }

    @RequestMapping("/editMessageById")
    public AIResult editMessageById(Integer messagesId) {
        messagesService.editMessageById(messagesId);
        return AIResult.ok("删除成功");
    }
}
