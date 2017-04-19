package com.clem.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by laileon on 2017/3/11.
 */

//restController返回与controller不一样

//@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。
//
//        1)如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，配置的视图解析器InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
//        例如：本来应该到success.jsp页面的，则其显示success.
//
//        2)如果需要返回到指定页面，则需要用 @Controller配合视图解析器InternalResourceViewResolver才行。
//        3)如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解。

@Controller
public class ThymeLeafController {
    @RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "www.leon.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }

    @RequestMapping("/security")
    public String securityIndex() {
        return "security";
    }
    @RequestMapping("/security_hello")
    public String securityHello() {
        return "security_hello";
    }
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
