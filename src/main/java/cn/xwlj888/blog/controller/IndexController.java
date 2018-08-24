package cn.xwlj888.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author
 * @create 2018-08-22 13:05
 **/
@Controller
public class IndexController {
    @RequestMapping("/")
    public String getIndex(){
        return "homepage/index";
    }
}
