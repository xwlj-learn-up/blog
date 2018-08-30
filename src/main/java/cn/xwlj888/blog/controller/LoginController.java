package cn.xwlj888.blog.controller;

import cn.xwlj888.blog.common.UserEnum;
import cn.xwlj888.blog.pojo.User;
import cn.xwlj888.blog.service.UserService;
import cn.xwlj888.blog.util.DateUtil;
import cn.xwlj888.blog.util.IpAdrressUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * @author
 * @create 2018-08-29 11:35
 **/
@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserService userService;
    /**
     * 后台登录
     * @param username
     * @param userpwd
     * @param code
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/manager",method = RequestMethod.POST)
    public String login(String username, String userpwd, String code, HttpSession session, HttpServletRequest request) throws Exception {
        User user = userService.selectUser(username,userpwd);
        if (user != null) {
            log.info(user.getRole()+"--登录成功--"+DateUtil.formatTimestamp(user.getLasttime(),DateUtil.DATETIME_CN_FORMAT));
            session.setAttribute(UserEnum.ROLE.getCode(),user.getRole());
            session.setAttribute(UserEnum.USERNAME.getCode(),user.getUsername());
            session.setAttribute(UserEnum.UUID.getCode(),user.getId());
            session.setAttribute(UserEnum.LOGINED.getCode(),user.getLogined());
            session.setAttribute(UserEnum.LASTLOGINTIME.getCode(),DateUtil.formatTimestamp(user.getLasttime(),DateUtil.DATETIME_CN_FORMAT));
            session.setAttribute(UserEnum.LASTLOGINIP.getCode(),user.getLastip());
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

}
