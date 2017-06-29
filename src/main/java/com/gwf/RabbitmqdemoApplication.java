package com.gwf;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitmqdemoApplication implements CommandLineRunner{
	@Autowired
	RabbitTemplate rabbitTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqdemoApplication.class, args);
	}

	//定义目的地即队列，队列名称为my-queue
	@Bean
	public Queue wiselyQueue(){
		return new Queue("my-queue");
	}

	@Override
	public void run(String... strings) throws Exception {
		rabbitTemplate.convertAndSend("my-queue","来自RabbitMQ的问候"); //向队列发送my-queue
	}
}
