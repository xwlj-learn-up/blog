package cn.xwlj888.blog.service;

import cn.xwlj888.blog.pojo.User;

public interface UserService {
	User selectUser(String username, String userPwd);
}
