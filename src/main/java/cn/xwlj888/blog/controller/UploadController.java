package cn.xwlj888.blog.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import cn.xwlj888.blog.enums.AjaxResultCodeEnum;
import cn.xwlj888.blog.enums.FileTypeEnum;
import cn.xwlj888.blog.enums.UploadTypeEnum;
import cn.xwlj888.blog.enums.UserEnum;
import cn.xwlj888.blog.util.JsonResultUtil;
import com.github.pagehelper.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * @author zs
 */
@Slf4j
@Controller
@Scope("prototype")
@RequestMapping("uploadFile")
@PropertySource("/config/filePath.properties")
public class UploadController {
    @Value("${file.path}")
    private String path;
    @Value("${file.temp}")
    private String tempPath;
    @Value("${file.article}")
    private String articlePath;
    @Value("${file.head}")
    private String headPath;

    private String uuid;
    private String finalPath;

    @ResponseBody
    @RequestMapping(value = "upload")
    public String uploadTemp(@RequestParam("upfile") MultipartFile file, @RequestParam String type, HttpSession session) {
        try {
            uuid = (String) session.getAttribute(UserEnum.UUID.getCode());
            if (StringUtils.isNoneBlank(uuid)) {
                return saveFile(file, type);
            } else {
                return JsonResultUtil.getJsonResult(AjaxResultCodeEnum.ERROR, "未登录");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getJsonResult(AjaxResultCodeEnum.ERROR, "系统错误");
        }
    }


    /**
     * 保存操作
     *
     * @param multipartFile 文件主体
     * @param type          文件类别
     * @return json
     */
    private String saveFile(MultipartFile multipartFile, String type) {
        try {
            if (multipartFile != null) {
                String temp = tempPath + uuid + File.separator;
                if (StringUtil.isNotEmpty(temp)) {
                    File tempFile = new File(temp);
                    boolean f = tempFile.mkdirs();
                    if (!f) {
                        log.error(temp + "未创建");
                    }
                }
                if (!multipartFile.isEmpty() && StringUtil.isNotEmpty(multipartFile.getOriginalFilename())) {
                    String mPath = multipartFile.getOriginalFilename();
                    if (checkFileType(type, mPath)) {
                        //防止浏览器传的是绝对路径的时候,
                        if (mPath.contains(File.separator)) {
                            mPath = mPath.substring(mPath.lastIndexOf(File.separator), mPath.length());
                        }
                        if (UploadTypeEnum.ARTICLE_IMAGE.getCode().equals(type)) {
                            finalPath = temp + UUID.randomUUID() + "-" + mPath;
                        } else if (UploadTypeEnum.HEAD_IMAGE.getCode().equals(type)) {
                            finalPath = temp + mPath;
                        }
                        //文件最终存放位置
                        log.info("文件最终存放位置:" + finalPath);
                        File file = new File(finalPath);
                        if (!file.getParentFile().exists()) {
                            boolean f = file.getParentFile().mkdirs();
                            if (!f) {
                                log.error(file.getParentFile() + "未创建");
                            }
                        }
                        multipartFile.transferTo(file);
                        //返回给前台的路径做一下处理
                        if (UploadTypeEnum.HEAD_IMAGE.getCode().equals(type)) {
                            finalPath = finalPath.replace(headPath, "");
                        } else if (UploadTypeEnum.ARTICLE_IMAGE.getCode().equals(type)) {
                            finalPath = finalPath.replace(articlePath, "");
                        }
                        return JsonResultUtil.getJsonResult(AjaxResultCodeEnum.SUCCESS, finalPath);
                    } else {
                        return JsonResultUtil.getJsonResult(AjaxResultCodeEnum.ERROR, "文件类型错误");
                    }
                }
            } else {
                return JsonResultUtil.getJsonResult(AjaxResultCodeEnum.ERROR, "上传文件不能为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getJsonResult(AjaxResultCodeEnum.ERROR, "系统错误");
        }
        return JsonResultUtil.getJsonResult(AjaxResultCodeEnum.ERROR, "上传失败");
    }

    /**
     * 检查文件类型是否合法
     *
     * @param type  要判断的类型
     * @param mPath 文件名或文件路径
     * @return flag
     */
    private boolean checkFileType(String type, String mPath) {
        try {
            //获取后缀
            String prefix = mPath.substring(mPath.lastIndexOf(".") + 1).toLowerCase();
            if (UploadTypeEnum.HEAD_IMAGE.getCode().equals(type)
                    || UploadTypeEnum.ARTICLE_IMAGE.getCode().equals(type)) {
                if (FileTypeEnum.PNG.getCode().equals(prefix)
                        || FileTypeEnum.JPEG.getCode().equals(prefix)
                        || FileTypeEnum.GIF.getCode().equals(prefix)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取需要的路径
     *
     * @param type    文件类型
     * @param prePath 文件路径
     * @param flag    是否是临时的
     * @return prePath
     */
    private String getPath(String type, String prePath, boolean flag) {
        if (UploadTypeEnum.ARTICLE_IMAGE.getCode().equals(type)) {
            //最终路径存放的
            if (flag) {
                prePath = articlePath + prePath;
                //临时路径存放的
            } else {
                prePath = tempPath + prePath;
            }
        } else if (UploadTypeEnum.HEAD_IMAGE.getCode().equals(type)) {
            prePath = headPath + prePath;
        }
        return prePath;
    }
}
