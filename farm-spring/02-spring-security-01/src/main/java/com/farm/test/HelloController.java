package com.farm.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author z2yEs
 * @create 23:06
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String test(){
        return "hello";
    }

}
