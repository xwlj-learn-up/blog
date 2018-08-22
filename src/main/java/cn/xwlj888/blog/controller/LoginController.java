package cn.xwlj888.blog.controller;

import javax.servlet.http.HttpServletRequest;

import cn.xwlj888.blog.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UserService userService;
	@RequestMapping("/index")
	public String login(){
		return "manager/login";
	}
	@RequestMapping("loginUser")
	public String loginUser(HttpServletRequest request,String username,String userpwd){
		if (StringUtils.isNoneBlank(username) && StringUtils.isNoneBlank(userpwd)) {
			boolean flag = userService.loginUser(username,userpwd);
			if (flag) {
				request.getSession().setAttribute("user", username);
				return "redirect:/manager/index";  
			}
		}
		return "manager/login";
	}
}
