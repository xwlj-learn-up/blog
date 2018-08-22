package cn.xwlj888.blog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author
 * @create 2018-08-22 14:53
 **/
/*@Slf4j
@Controller
@RequestMapping(value = "error")
class MainsiteErrorController implements ErrorController {

    public String handleError(HttpServletRequest request){
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        log.info(statusCode+"");
        if(statusCode == 401){
            return "/401";
        }else if(statusCode == 404){
            return "/404";
        }else if(statusCode == 403){
            return "/403";
        }else{
            return "/500";
        }

    }
    @Override
    public String getErrorPath() {
        return "/error";
    }
}*/
