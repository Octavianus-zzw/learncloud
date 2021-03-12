package com.zzw.serviceribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    public String hiService(String name) {
        ServiceInstance instance = loadBalancerClient.choose("service-hi");
        URI uri = instance.getUri();
        String a = uri.toString();
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }
}
