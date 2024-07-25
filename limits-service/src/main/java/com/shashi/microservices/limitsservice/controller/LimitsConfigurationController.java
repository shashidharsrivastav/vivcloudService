package com.shashi.microservices.limitsservice.controller;

import com.shashi.microservices.limitsservice.Configuration;
import com.shashi.microservices.limitsservice.bean.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class
LimitsConfigurationController {
    @Autowired
    private Configuration configuration;
    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsFromConfiguration(){
        //1st return new LimitConfiguration(1000,200);
        return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
    }
}
