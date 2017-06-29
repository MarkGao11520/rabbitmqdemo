package com.gwf;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by gaowenfeng on 2017/4/9.
 */
@Component
public class Receiver {

    @RabbitListener(queues = "my-queue")
    public void receiveMessage(String message){
        System.out.println("Received <"+message+">");
    }
}
