package com.example.blog.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Helloserver {
    @RequestMapping(value="/hello")
    public static String SayHi() {
        return "Hello Local How are you My baby I am comming";
    }

}
class Test
{


    public static void main(String[] args) {
        Helloserver h=new Helloserver();
        h.SayHi();

    }


}
