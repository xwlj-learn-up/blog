package cn.xwlj888.blog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author
 * @create 2018-08-22 14:53
 **/

@Slf4j
@Controller
@RequestMapping(value = "error")
public class ErrorController{
    @RequestMapping("/404")
    public String error_404(){
        return "/error/404";
    }
}

