package cn.xwlj888.blog.service.impl;


import cn.xwlj888.blog.mybatis.ArticleMapper;
import cn.xwlj888.blog.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class ArticleServiceImpl implements ArticleService {
	@Resource
	private ArticleMapper articleMapper;

/*	@Override
	public List<Article> getArticles() {
		return articleMapper.selectAll();
	}*/

	//@Override
	//public void add(ArticleInfo article) {
	/*	//articleMapper.add(article);
		Article article2 = new Article();
		article2.setAbstr(article.getDescribe());
		article2.setCategoryid(article.getCategory().toString());
		//article2.setCategoryvalue(article.getCategory());
		//article2.setContentid(Integer.valueOf(article.getContent()));
		article2.setCreatedate(Calendar.getInstance().getTime());
		article2.setImgurl(article.getTitlepic());
		article2.setKeyvalue(article.getKeywords());
		article2.setTitle(article.getTitle());
		//article2.set
		articleMapper.insert(article2);*/
	//}
	
}
