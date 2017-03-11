package com.clem.web;

import com.clem.error.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by laileon on 2017/3/1.
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/testError")
    public String testError() throws Exception{
        throw new Exception("发生错误-1");
    }

    @RequestMapping("/json")
    public String testError2() throws Exception{
        throw new MyException("发生错误-2");
    }
}
