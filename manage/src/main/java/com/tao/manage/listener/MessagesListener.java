package com.tao.manage.listener;

import com.tao.manage.bean.Messages;
import com.tao.manage.service.MessagesService;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MessagesListener {
    @Autowired
    private MessagesService messageService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "matao.announce.queue",durable = "true"), //队列持久化
            exchange = @Exchange(
                    value = "matao.announce.exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.TOPIC
            )

    ))
    @RabbitHandler
    public void addAnnounce(Map<String,Object> map){
        messageService.saveAnnounce(map);

    }


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "matao.comment.queue",durable = "true"), //队列持久化
            exchange = @Exchange(
                    value = "matao.comment.exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.TOPIC
            )
    ))
    public void addComment(Map<String,Object> map, Channel channel, Message message) {
        System.out.println("ack.test接收到的消息 : " + map);
        System.out.println(message);
        try {
            Messages messages=new Messages();
            messages.setStatus(false);
            messages.setTitle((String) map.get("title"));
            messages.setContent((String) map.get("content"));
            messages.setFromUser((Integer) map.get("fromUser"));
            messages.setToUser((Integer) map.get("toUser"));
            messages.setSentTime((String) map.get("sentTime"));
            messages.setContentId((Integer) map.get("contentId"));
            messages.setCourseId((Integer) map.get("courseId"));
            messages.setType((Integer) map.get("type"));
            messageService.saveComment(messages);
 channel.basicAck(message.getMessageProperties().getDeliveryTag(), true); // 消息的标识，false只确认当前一个消息收到，true确认所有consumer获得的消息
// channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true); // ack返回false，并重新回到队列，api里面解释得很清楚
// channel.basicReject(message.getMessageProperties().getDeliveryTag(), true); // 拒绝消息
//            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true); // ack返回false，并重新回到队列，api里面解释得很清楚
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "matao.agree.queue",durable = "true"), //队列持久化
            exchange = @Exchange(
                    value = "matao.agree.exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.TOPIC
            )
    ))
    @RabbitHandler
    public void addAgree(Map<String,Object> map){
        Messages messages=new Messages();
        messages.setContent((String) map.get("content"));
        messages.setFromUser((Integer) map.get("fromUser"));
        messages.setToUser((Integer) map.get("toUser"));
        messages.setSentTime((String) map.get("sentTime"));
        messages.setStatus(false);
        messages.setContent((String) map.get("content"));
        messages.setType((Integer) map.get("type"));
        messageService.saveAgree(messages);

    }


}
