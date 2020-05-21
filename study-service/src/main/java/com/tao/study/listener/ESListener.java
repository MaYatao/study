package com.tao.study.listener;

import com.rabbitmq.client.Channel;
import com.tao.study.es.ElasticOperationService;
import com.tao.study.es.SeachService;
import com.tao.study.es.SearchParam;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ESListener {
    @Autowired
    private SeachService esService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "message.announce.queue",durable = "true"), //队列持久化
            exchange = @Exchange(
                    value = "message.announce.exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.TOPIC
            )

    ))
    @RabbitHandler
    public void addAnnounce(Map<String,Object> map){
        SearchParam param=new SearchParam();
        esService.add(param);

    }


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "message.comment.queue",durable = "true"), //队列持久化
            exchange = @Exchange(
                    value = "message.comment.exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.TOPIC
            )
    ))
    public void addComment(Map<String,Object> map, Channel channel, Message message) {
        System.out.println("ack.test接收到的消息 : " + map);
        System.out.println(message);
        try {
            SearchParam param=new SearchParam();
            esService.update(param);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true); // 消息的标识，false只确认当前一个消息收到，true确认所有consumer获得的消息
// channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true); // ack返回false，并重新回到队列，api里面解释得很清楚
// channel.basicReject(message.getMessageProperties().getDeliveryTag(), true); // 拒绝消息
//            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true); // ack返回false，并重新回到队列，api里面解释得很清楚
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "message.agree.queue",durable = "true"), //队列持久化
            exchange = @Exchange(
                    value = "message.agree.exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.TOPIC
            )
    ))
    @RabbitHandler
    public void addAgree(Map<String,Object> map){
        SearchParam param=new SearchParam();
        esService.deleted(param);

    }


}
