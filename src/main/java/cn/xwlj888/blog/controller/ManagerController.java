package cn.xwlj888.blog.controller;


import cn.xwlj888.blog.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 后台管理界面
 * @author zs
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @RequestMapping
    public String index() {
        return "/manager/index";
    }

    @RequestMapping("alogin")
    public String login() {
        return "/manager/login";
    }

    @RequestMapping("article")
    public String article() {
        try {
            //List<?> list = managerService.findAllArtivleInfo();
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
