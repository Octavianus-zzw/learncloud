package com.zzw.test.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class KafkaProducerController {
    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    @GetMapping("/kafka/normal/{message}")
    public String  sendMessage(@PathVariable("message") String normalMessage) {
        kafkaTemplate.send("topic1", normalMessage).addCallback(success -> {
            System.out.println("发送成功");
        }, failure -> {
            System.out.println("发送失败");
        });
        return "ok";
    }
}
