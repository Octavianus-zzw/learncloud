package com.zzw.servicehi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/hi")
    public String HelloController(@RequestParam String name) {
        return "hi " + name + ",i am from port:" + port;
    }
}
