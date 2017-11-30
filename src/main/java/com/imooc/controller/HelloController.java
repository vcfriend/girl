package com.imooc.controller;

import com.imooc.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * xxx
 * @author 向亚林
 * 2017/11/28
 */
@RestController
@RequestMapping("/girl")
public class HelloController {
    @Value("${girl.cupSize}")
    private String cupSize;
    @Value("${girl.age}")
    private String age;
    @Value("${content}")
    private  String content;
    @Autowired
    private GirlProperties girlProperties;


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say(){
        return  "Hello Spring Boot!";
    }

    @RequestMapping(value = "cup", method = RequestMethod.GET)
    public String cup(){
        return content;
    }
    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info(){
        return girlProperties.toString();
    }
    @GetMapping(value = "/say1")
    public String say1(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId){
        return "say1 id: " + myId;
    }
    @RequestMapping(value = "/say2/{id}", method = RequestMethod.GET)
    public String say2(@PathVariable("id") Integer myId){
        return "say2 id: " + myId;
    }
}
