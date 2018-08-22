package cn.xwlj888.blog.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

@Slf4j
@Controller
@RequestMapping("aptcha")
public class KaptchaController {
	@Autowired
	private Producer producer;
	
	@RequestMapping("/setCaptcha")
	public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.setDateHeader("Expires", 0);
		// 禁止server端缓存
		// 设置标准的 HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		// 设置IE扩展 HTTP/1.1 no-cache headers (use addHeader).
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		// 设置标准 HTTP/1.0 不缓存图片
		response.setContentType("image/jpeg");
		// 返回一个 jpeg 图片，默认是text/html(输出文档的MIMI类型)
		String capText = producer.createText();
		// 为图片创建文本
		// 将文本保存在session中。这里就使用包中的静态变量吧
		request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
		BufferedImage bi = producer.createImage(capText);
		// 创建带有文本的图片
		ServletOutputStream out = response.getOutputStream();
		// 图片数据输出
		ImageIO.write(bi, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}

		System.out.println("Session 验证码是：" + request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY));
		return null;
	}
	
	@RequestMapping("validateCode")
	public String validateCode(HttpServletRequest request,@RequestParam(value="code",required=true) String code) throws Exception{
		String setcode = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if (StringUtils.isNoneEmpty(code) || !code.equals(setcode)) {
			log.info("验证码错误");
			return "codeErr";
		}
		return "success";
	}
}
