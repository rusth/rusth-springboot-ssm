package cn.rusth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页拦截器
 * Created by rusth on 2017/7/13.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "forward:/index.html";
    }
}
