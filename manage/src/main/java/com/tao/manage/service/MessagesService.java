package com.tao.manage.service;

import com.github.pagehelper.PageInfo;
import com.tao.manage.bean.MessageResult;
import com.tao.manage.bean.Messages;

import java.util.Map;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 23:17
 **/
public interface MessagesService {
    void saveAgree(Messages message);

    void saveComment(Messages message);

    void saveAnnounce(Map<String, Object> map);

    PageInfo<MessageResult> getMessageByUid(Integer page, Integer row, Integer userId, Integer type);

    void deleteMessageById(Integer messagesId);

    void editMessageById(Integer messagesId);
}
