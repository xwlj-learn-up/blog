package cn.xwlj888.blog.service.impl;

import java.util.List;

import cn.xwlj888.blog.mybatis.UserMapper;
import cn.xwlj888.blog.pojo.User;
import cn.xwlj888.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.ListUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;


/**
 * @author zs
 */
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;


	@Override
	public User selectUser(String username, String password) {
		Example example = new Example(User.class);
		example.createCriteria()
				.andEqualTo("username",username)
				.andEqualTo("password",password);
		return userMapper.selectOneByExample(example);
	}
}
