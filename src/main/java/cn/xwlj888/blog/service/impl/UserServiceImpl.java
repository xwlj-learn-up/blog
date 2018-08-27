package cn.xwlj888.blog.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import cn.xwlj888.blog.mybatis.UserMapper;
import cn.xwlj888.blog.pojo.User;
import cn.xwlj888.blog.service.UserService;
import cn.xwlj888.blog.util.DateUtil;
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
				.andEqualTo("email",username)
				.andEqualTo("password",password);
		User user =  userMapper.selectOneByExample(example);
		return  user;
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateByPrimaryKey(user);
	}
}
