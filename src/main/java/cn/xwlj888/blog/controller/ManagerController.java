package cn.xwlj888.blog.controller;


import cn.xwlj888.blog.common.UserEnum;
import cn.xwlj888.blog.pojo.User;
import cn.xwlj888.blog.service.ManagerService;
import cn.xwlj888.blog.service.UserService;
import cn.xwlj888.blog.util.DateUtil;
import cn.xwlj888.blog.util.IpAdrressUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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

    /**
     * 后台管理首页
     * @param session
     * @return
     */
    @RequestMapping
    public String index(HttpSession session, ModelMap map) {
        Integer uuid = (Integer) session.getAttribute(UserEnum.UUID.getCode());
        if (uuid != null){

            map.addAttribute("","");


            return  "/manager/index";
        }
        return "/manager/login";
    }

    /**
     * 后台登录
     * @param username
     * @param userpwd
     * @param code
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(String username, String userpwd, String code, HttpSession session, HttpServletRequest request) throws Exception {
        User user = userService.selectUser(username,userpwd);
        if (user != null) {
            log.info(user.getRole()+"--登录成功--"+Calendar.getInstance().getTime());
            session.setAttribute(UserEnum.ROLE.getCode(),user.getRole());
            session.setAttribute(UserEnum.USERNAME.getCode(),user.getUsername());
            session.setAttribute(UserEnum.UUID.getCode(),user.getId());
            String ip = IpAdrressUtil.getIpAdrress(request);

            Integer logined = user.getLogined();
            if (logined == null){
                user.setLogined(0);
            }
            user.setLogined(logined+1);
            user.setLasttime(Timestamp.valueOf(DateUtil.formatTimestamp(new Date(),DateUtil.DATETIME_HORIZONTAL_FORMAT)));
            user.setLastip(ip);
            userService.updateUser(user);
        }
        return "redirect:/manager";
    }

    @RequestMapping("article")
    public String article(HttpSession session) {
        try {
            System.out.println(session.getAttribute(UserEnum.ROLE.getCode()));
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
