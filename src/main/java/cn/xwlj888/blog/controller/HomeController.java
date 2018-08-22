package cn.xwlj888.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * @author zs
 */
@Controller
@RequestMapping("/home")
public class HomeController {
	//@Autowired
	//private ArticleService articleService;

	@RequestMapping(value="/article")
	public String getArticle(Model model){
		//List<Article> articles = articleService.getArticles();
		//model.addAttribute("articles", articles);
		return "homepage/article";
	}
	@RequestMapping(value="category")
	public String getCategory(Model model){
		//List<Article> articles = articleService.getArticles();
		//model.addAttribute("articles", articles);
		return "homepage/category";
	}
	@RequestMapping(value="links")
	public String getLinks(Model model){
		//List<Article> articles = articleService.getArticles();
		//model.addAttribute("articles", articles);
		return "homepage/links";
	}
	@RequestMapping(value="readers")
	public String getReaders(Model model){
		//List<Article> articles = articleService.getArticles();
		//model.addAttribute("articles", articles);
		return "homepage/readers";
	}
	@RequestMapping(value="tags")
	public String getTags(Model model){
		//List<Article> articles = articleService.getArticles();
		//model.addAttribute("articles", articles);
		return "homepage/tags";
	}
	/*@RequestMapping(value="upgrade-browser")
	public String getUpGradeBrowser(Model model){
		//List<Article> articles = articleService.getArticles();
		//model.addAttribute("articles", articles);
		return "homepage/upgrade-browser";
	}*/
	@RequestMapping(value="upgrade-browser")
	public String getUpGradeBrowser(Model model){
		//List<Article> articles = articleService.getArticles();
		//model.addAttribute("articles", articles);
		return "homepage/upgrade-browser";
	}
}
