package cn.xwlj888.blog.service.impl;

import cn.xwlj888.blog.mybatis.ArticleMapper;
import cn.xwlj888.blog.service.ManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class ManagerServiceImpl implements ManagerService {
	@Resource
	private ArticleMapper articleMapper;

	}
