package com.fanjie.travel;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stu")
public class TestController {

    @RequestMapping("/index")
    public String fun(){
        return "Hello World";
    }
}

