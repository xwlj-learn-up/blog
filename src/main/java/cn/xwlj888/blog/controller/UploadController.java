package cn.xwlj888.blog.controller;

import java.io.File;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author zs
 */
@Slf4j
@Controller
@RequestMapping("uploadFile")
public class UploadController {
    @ResponseBody
    @RequestMapping(value = "uploadTemp")
    public String uploadTemp(@RequestParam("upfile") MultipartFile file) {
        if (file.isEmpty()) {
            return "false";
        }
        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize();
        log.info(fileName + "-->" + size);
        String path = "D:/home/temp";
        File dest = new File(path + "/" + fileName);
        //判断文件父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        try {
            //保存文件
            file.transferTo(dest);
            return "{\"state\":\"SUCCESS\",\"url\":\"/image/getImage?tempPath=" + fileName + "\",\"title\":\""+fileName+"\",\"original\":\""+fileName+"\"}";
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return "false";
        } catch (IOException e) {
            e.printStackTrace();
            return "false";
        }
    }
}
