package cn.xwlj888.blog.controller;


import cn.xwlj888.blog.enums.UserEnum;
import cn.xwlj888.blog.service.ArticleService;
import cn.xwlj888.blog.service.ManagerService;
import cn.xwlj888.blog.service.UserService;
import cn.xwlj888.blog.util.JsonResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


/**
 * 后台管理控制器
 * @author zs
 */
@Controller
@RequestMapping("/manager")
@Slf4j
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    UserService userService;
    @Autowired
    ArticleService articleService;

    /**
     * 后台管理首页
     * @param session
     * @return
     */
    @RequestMapping
    public String index(HttpSession session) {
        Integer uuid = (Integer) session.getAttribute(UserEnum.UUID.getCode());
        if (uuid != null){
            return  "/manager/index";
        }
        return "/manager/login";
    }

    /**
     * 获取信息总览中的四个数量
     * @return
     */
    @PostMapping("getCount")
    @ResponseBody
    public String getCount(HttpSession session){
        Integer commontCount = 3;
        Integer flinkCount = 4;
        Integer viewCount = 5;
        Integer articlCount = articleService.getCount();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("articlCount",articlCount);
        map.put("commontCount",commontCount);
        map.put("flinkCount",flinkCount);
        map.put("viewCount",viewCount);
        return JsonResultUtil.mapToString("success",map);
    }






    @RequestMapping("article")
    public String article(HttpSession session) {
        try {
            return "/manager/article";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    @RequestMapping("category")
    public String category() {
        return "/manager/category";
    }

    @RequestMapping("notice")
    public String notice() {
        return "/manager/notice";
    }

    @RequestMapping("comment")
    public String comment() {
        return "/manager/comment";
    }

    @RequestMapping("flink")
    public String flink() {
        return "/manager/flink";
    }

    @RequestMapping("manage-user")
    public String manageUser() {
        return "/manager/manage-user";
    }

    @RequestMapping("readset")
    public String readset() {
        return "/manager/comment";
    }

    @RequestMapping("add-article")
    public String addArticle() {
        return "/manager/add-article";
    }

    @RequestMapping("setting")
    public String setting() {
        return "/manager/setting";
    }

    @RequestMapping("loginlog")
    public String loginlog() {
        return "/manager/loginlog";
    }
}
