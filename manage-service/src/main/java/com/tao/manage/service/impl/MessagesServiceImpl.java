package com.tao.manage.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tao.blog.mapper.ContentMapper;
import com.tao.course.mapper.CoursesMapper;
import com.tao.manage.pojo.MessageResult;
import com.tao.manage.bean.Messages;
import com.tao.manage.mapper.MessagsMapper;
import com.tao.manage.service.MessagesService;
import com.tao.user.bean.User;
import com.tao.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 23:21
 **/
@Service
public class MessagesServiceImpl implements MessagesService {

    @Autowired
    private MessagsMapper messagsMapper;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ContentMapper contentMapper;

    @Autowired
    private CoursesMapper coursesMapper;

    private List<Messages> messagesServices;

    @Override
    public void saveAgree(Messages messages) {
        messagsMapper.insert(messages);
    }

    @Override
    public void saveComment(Messages messages) {
        messagsMapper.insert(messages);
    }

    @Override
    public void saveAnnounce(Map<String, Object> map) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        Integer type = (Integer) map.get("type");
        if (type == 1) {
            criteria.andEqualTo("identity", 0);
        }
        if (type == 2) {
            criteria.andEqualTo("identity", 1);
        }
        List<User> userList = userMapper.selectByExample(example);
        for (User user : userList) {
            Messages messages = new Messages();
            messages.setTitle((String) map.get("title"));
            messages.setContent((String) map.get("content"));
            messages.setFromUser((Integer) map.get("fromUser"));
            messages.setToUser(user.getUserId());
            messages.setSentTime((String) map.get("sentTime"));
            messages.setContent((String) map.get("content"));
            messages.setStatus(false);
            messages.setType(0);
            messagsMapper.insert(messages);
        }

    }

    @Override
    public PageInfo<MessageResult> getMessageByUid(Integer page, Integer row, Integer userId, Integer type) {
        Example example = new Example(Messages.class);
        example.orderBy("status");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type", type);
        criteria.andEqualTo("toUser", userId);
        List<Messages> messagesList = messagsMapper.selectByExample(example);
        List<MessageResult> messageResults = new ArrayList<>();
        for (Messages messages : messagesList) {
            MessageResult messageResult = new MessageResult();
            if (messages.getFromUser() == -1) {
                messageResult.setFromUserName("网站管理员");
            } else {
                User formUser = userMapper.selectByPrimaryKey(messages.getFromUser());
                messageResult.setToUser(messages.getFromUser());
                messageResult.setToUserName(formUser.getUsername());
                messageResult.setToUserImage(formUser.getHeadImage());
            }
            User toUser = userMapper.selectByPrimaryKey(messages.getToUser());
            messageResult.setToUser(messages.getToUser());
            messageResult.setMessagesId(messages.getMessageId());
            messageResult.setTitle(messages.getTitle());
            messageResult.setToUserName(toUser.getUsername());
            messageResult.setToUserImage(toUser.getHeadImage());
            messageResult.setContent(messages.getContent());
            messageResult.setTitle(messages.getTitle());
            if (messages.getCourseId() != null) {
                messageResult.setContent(coursesMapper.selectByPrimaryKey(messages.getCourseId()).getTitle());
            }
            if (messages.getContentId() != null) {
                messageResult.setContent(contentMapper.selectByPrimaryKey(messages.getContentId()).getTitle());
            }
            messageResult.setSentTime(messages.getSentTime());
            messageResult.setStatus(messages.getStatus());
            messageResults.add(messageResult);
        }
        PageHelper.startPage(page, row);
        PageInfo<MessageResult> pages = new PageInfo<MessageResult>(messageResults);
        return pages;
    }

    @Override
    public void deleteMessageById(Integer messagesId) {
        messagsMapper.deleteByPrimaryKey(messagesId);

    }

    @Override
    public void editMessageById(Integer messagesId) {
        Messages messages = messagsMapper.selectByPrimaryKey(messagesId);
        messages.setStatus(Boolean.TRUE);
        messagsMapper.updateByPrimaryKeySelective(messages);
    }
}
