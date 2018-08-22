package cn.xwlj888.blog.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;


/**
 * @author zs
 */
@Controller
@RequestMapping("image")
public class ImageController {
	@RequestMapping(value="getImage",method=RequestMethod.GET)
	@ResponseBody
	public String getImage(HttpServletRequest request,HttpServletResponse response){
		try {
			String params = request.getQueryString();
			if (StringUtils.isNotBlank(params)) {
				String[] paramArray = params.split("=");
				if (StringUtils.isNoneBlank(paramArray)) {
					String type = paramArray[0];
					String param = paramArray[1];
					String filPath = "D:/home/temp/";
					if ("a".equals(type)) {
						filPath = "a";
					}
					filPath = filPath + param;
					File file = new File(filPath);
					if (file.exists()) {
						FileInputStream fs = new FileInputStream(file);
						//获取图片二进制长度
						int length = fs.available();
						byte[] buffer = new byte[length];
						fs.read(buffer);
						response.getOutputStream().write(buffer);
						response.getOutputStream().close();
						response.getOutputStream().flush();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
