package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Julian on 2017/3/1.
 */
@RestController
public class Hello {
    @RequestMapping("/")
    String index(){
        return "Hello word hot man reload ";
    }
}
