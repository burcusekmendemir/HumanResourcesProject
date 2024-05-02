package com.project.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    private final String EXCHANGE_EMPLOYEE = "employee-exchange";
    private final String QUEUE_EMPLOYEE = "employee-queue";
    private final String QUEUE_MANAGER = "manager-queue";
    private final String BINDING_KEY_EMPLOYEE = "employee-binding-key";

    @Bean
    DirectExchange directExchange(){
        return new DirectExchange(EXCHANGE_EMPLOYEE);
    }

    @Bean
    Queue queueEmployee(){
        return new Queue(QUEUE_EMPLOYEE);
    }

    @Bean
    Queue queueManager(){
        return new Queue(QUEUE_MANAGER);
    }

    @Bean
    Binding bindingEmployee(final DirectExchange directExchange, final Queue queueEmployee){
        return BindingBuilder.bind(queueEmployee).to(directExchange).with(BINDING_KEY_EMPLOYEE);
    }


}
