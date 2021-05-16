package com.kkb.retailercenter.controller;

import com.kkb.retailer.center.api.TestService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Reference
    private TestService testService;

    @GetMapping("/hello")
    public String helloWorld(){
        return "helloWorld";
    }

    @GetMapping("/getMessage")
    public String getMessage(){
        return testService.getMessage();
    }
}
