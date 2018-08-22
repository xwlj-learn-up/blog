package cn.xwlj888.blog.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("uploadFile")
public class UploadController {
	@ResponseBody
	@RequestMapping(value="uploadTemp")
	public String uploadTemp(@RequestParam("upfile") MultipartFile file){
		 if(file.isEmpty()){
	            return "false";
	        }
	        String fileName = file.getOriginalFilename();
	        int size = (int) file.getSize();
	        System.out.println(fileName + "-->" + size);
	        String path = "D:/home/temp" ;
	        File dest = new File(path + "/" + fileName);
	        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
	            dest.getParentFile().mkdir();
	        }
	        try {
	            file.transferTo(dest); //保存文件
	            return "{\"state\":\"SUCCESS\",\"url\":\"/image/getImage?tempPath="+fileName+"\",\"title\":\"demo.jpg\",\"original\":\"demo.jpg\"}";
	        } catch (IllegalStateException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            return "false";
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            return "false";
	        }
	}
	}
