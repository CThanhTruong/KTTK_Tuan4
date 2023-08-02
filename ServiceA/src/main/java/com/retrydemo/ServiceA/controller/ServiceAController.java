package com.retrydemo.ServiceA.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.xml.crypto.Data;
import java.util.Date;

@RestController
@RequestMapping("/a")
public class ServiceAController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String Base_URL = "http://localhost:8081/";

    private static final String SERVICE_A = "serviceA";
    int count=1;
    @GetMapping
 //   @CircuitBreaker(name = SERVICE_A, fallbackMethod = "serviceAFallback")
    @Retry(name = SERVICE_A)
    public String serviceA(){
        String url = Base_URL + "/b";
        System.out.println("Retry" + count++ + "times" + new Date());
        return restTemplate.getForObject(
                url,
                String.class
        );
    }

    public String serviceAFallback(Exception e){
        return "day la phuong thuc tra ve cua Service A";
    }
}
