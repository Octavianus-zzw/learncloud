package com.zzw.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopTestController {

    @GetMapping(value = "/aoptest")
    public String aopTest() {
        System.out.println("controller print");
        return "ok";
    }
}
