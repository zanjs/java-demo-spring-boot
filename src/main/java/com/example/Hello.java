package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Hello {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "Hello word hot man reload ！1";
    }
}
