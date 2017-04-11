package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Decode {

    private DecoderService decoderService;
    private static final String FilePath = "E://code.jpg";

    @RequestMapping("/decode")
    public String decode(){
        return new DecoderService().decodeService(FilePath);
    }


}
