package cn.xwlj888.blog.enums;

/**
 * @author
 * @create 2018-09-05 9:57
 **/
public enum  UploadTypeEnum {
    /**
     * 头像
     */
    HEAD_IMAGE("HEAD_IMAGE", "头像"),
    /**
     * article图片
     */
    ARTICLE_IMAGE("ARTICLE_IMAGE","article图片");


    private String code;
    private String message;

    private UploadTypeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
