package cn.xwlj888.blog.service.impl;

import java.util.List;

import cn.xwlj888.blog.mybatis.UserMapper;
import cn.xwlj888.blog.pojo.User;
import cn.xwlj888.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.ListUtils;

import javax.annotation.Resource;


@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;

	@Override
	public boolean loginUser(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		//List<User> u =  userMapper.select(user);
		/*if (!ListUtils.isEmpty(u)) {
			return true;
		}*/
		
		return false;
	}
	
}
