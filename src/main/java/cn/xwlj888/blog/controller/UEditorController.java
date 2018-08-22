package cn.xwlj888.blog.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ueditor")
public class UEditorController {
	@RequestMapping(value="config")  
    public String config(HttpServletRequest request, HttpServletResponse response) {
		System.err.println(request.getParameter("action"));
        	response.setContentType("application/json");  
        	//String rootPath = request.getSession().getServletContext().getRealPath("/");  
        	String callback = null;
        try {  
        	  response.setContentType("application/json;charset=utf-8");
              Resource resource = new ClassPathResource("config.json");
              File file = resource.getFile();
              BufferedReader br = new BufferedReader(new FileReader(file));
              StringBuilder stringBuilder = new StringBuilder();
              String line;
              while ((line = br.readLine()) != null) {
                  stringBuilder.append(line);
              }
              callback = stringBuilder.toString();
              return callback;
          } catch (Exception e) {
              e.printStackTrace();
              callback = "error";
          }
		return callback;
    } 
	/*@ResponseBody
	@RequestMapping("uploadimage")
	public String uploadTemp(){
		
		System.err.println(12221);
		
		return null;
	}*/
	//action == '' || action == 'uploadscrawl' || action == 'uploadimage'
}
