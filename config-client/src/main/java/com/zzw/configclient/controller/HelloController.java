package com.zzw.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${foo}")
    private String foo;

    @Value("${democonfigclient.message}")
    private String msg;

    @GetMapping(value = "/hi")
    public String hi() {
        return foo;
    }

    @GetMapping(value = "/msg")
    public String msg() {
        return msg;
    }
}
