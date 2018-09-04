package cn.xwlj888.blog.common;

/**
 * Created with IntelliJ IDEA.
 * User: iron
 * Date: 15-11-13
 * Time: 下午10:48
 * Des:
 */

public enum AjaxResultCodeEnum {

    SUCCESS("success", "成功"),

    FAIL("fail","失败"),

    ERROR("error","错误");

    private String code;
    private String message;

    private AjaxResultCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "AjaxResultCodeEnum{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
