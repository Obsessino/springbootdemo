package com.xdclass.controller;

import com.xdclass.entity.Order;
import com.xdclass.jms.JmsProducer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Obsession.yin
 * @date 2020/3/16
 */
@RestController
public class OrderController {

    @Autowired
    private JmsProducer producer;

    private static final String topic = "test_topic_xdclass";

    @RequestMapping("/helloWorld")
    public String sendMsg(@RequestParam String text) throws Exception{
        Message message = new Message(topic,"tag",("xdclass_MQ"+text).getBytes());
        message.setDelayTimeLevel(2);
       producer.getProducer().send(message, new MessageQueueSelector() {
           @Override
           public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
               int ququeNem = Integer.parseInt(arg.toString());
               System.out.println(mqs.size());
               return mqs.get(ququeNem);
           }
       },0);
    return "......";

    }

    public void testgitV2(){
        System.out.println("this is v2");
        System.out.println("master");
        System.out.println("v2");
        System.out.println("789");
        System.out.println("master 2");
        System.out.println("v2 2");

    }
}
