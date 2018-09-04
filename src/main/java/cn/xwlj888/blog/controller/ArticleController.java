package cn.xwlj888.blog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("article")
public class ArticleController {
	//@Autowired
	//private ArticleService articleService;
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	//@ResponseBody
	public String add(){
		//articleService.add(article);
		return "redirect:/article?id=";
	}
}
