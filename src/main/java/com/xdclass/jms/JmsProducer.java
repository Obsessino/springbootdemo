package com.xdclass.jms;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.stereotype.Component;

/**
 * @author Obsession.yin
 * @date 2020/3/16
 */
@Component
public class JmsProducer {

    private String producerGroup = "pay_producer";

    private String nameServerAddr = "192.168.181.137:9876";

    private DefaultMQProducer producer;
    public JmsProducer(){
        producer = new DefaultMQProducer(producerGroup);
        producer.setNamesrvAddr(nameServerAddr);
        //消息投递重试次数，默认两次
        producer.setRetryTimesWhenSendFailed(3);
        start();
    }

    public DefaultMQProducer getProducer(){
        return this.producer;
    }


    public void start(){
        try {
            producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    public void shutDown(){
        producer.shutdown();
    }

}
