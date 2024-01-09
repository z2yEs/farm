package com.farm.test;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author z2yEs
 * @create 23:31
 */

@RestController
public class TestController {

    @Value("${serviceName}")
    private String applicationName;

    @GetMapping("/getApplicationName")
    public String getApplicationName(){
        return applicationName;
    }

}
