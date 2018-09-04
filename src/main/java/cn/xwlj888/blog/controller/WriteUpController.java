package cn.xwlj888.blog.controller;

import cn.xwlj888.blog.common.AjaxResultCodeEnum;
import cn.xwlj888.blog.util.JsonResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.jodconverter.DocumentConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.util.StringUtil;

import javax.annotation.Resource;
import java.io.File;

/**
 * WriteUp相关
 * @author
 * @create 2018-09-03 18:35
 **/
@Slf4j
@Controller
@RequestMapping("wordToPdf")
@Scope("prototype")
@PropertySource("/config/filePath.properties")
public class WriteUpController{
    @Value("${file.path}")
    private String path;
    @Value("${file.temp}")
    private String tempPath;
    @Value("${file.xxx}")
    private String xxxPath;

    @Resource
    private DocumentConverter documentConverter;

    @RequestMapping("create")
    @ResponseBody
    public String createWriteUp(@RequestParam("file")MultipartFile multipartFile){
        try {
          if (!multipartFile.isEmpty()){
              String mpath = multipartFile.getOriginalFilename();
              String prefix = mpath.substring(mpath.lastIndexOf(".")+1);

            if (!StringUtil.isEmpty(prefix)){
                if (("doc".equals(prefix.toLowerCase())
                        || "docx".equals(prefix.toLowerCase()))){
                    if (mpath.contains(File.separator)){
                        mpath = mpath.substring(mpath.lastIndexOf(File.separator),mpath.length());
                    }
                    //文件最终存放位置
                    xxxPath = xxxPath+File.separator+ StringUtils.randomAlphanumeric(8)+"-" +mpath;
                    log.info(xxxPath);
                    File file = new File(xxxPath);
                    if (!file.getParentFile().exists()){
                        file.getParentFile().mkdirs();
                    }
                    multipartFile.transferTo(file);
                    Thread.sleep(500);
                    //pdf存放位置
                    String pdfPath = xxxPath.substring(0,xxxPath.lastIndexOf(".")+1)+"pdf";
                    File file1 = new File(pdfPath);
                    if (!file1.exists()){
                        file1.createNewFile();
                    }
                    documentConverter.convert(file).to(file1).execute();
                    return JsonResultUtil.getJsonResult(AjaxResultCodeEnum.SUCCESS,file1);
                }else{
                    return JsonResultUtil.getJsonResult(AjaxResultCodeEnum.ERROR,"文件类型错误");
                }
            }
          }
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getJsonResult(AjaxResultCodeEnum.ERROR,"上传失败");
        }
        return JsonResultUtil.getJsonResult(AjaxResultCodeEnum.ERROR,"上传失败");
    }


}
