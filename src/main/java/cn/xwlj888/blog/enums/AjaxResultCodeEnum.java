package cn.xwlj888.blog.enums;

/**
 * Created with IntelliJ IDEA.
 * Date: 15-11-13
 * Time: 下午10:48
 * Des:
 * @author zs
 */

public enum AjaxResultCodeEnum {
    /**
     * 成功
     */
    SUCCESS("success", "成功"),
    /**
     * 失败
     */
    FAIL("fail","失败"),
    /**
     * 错误
     */
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
}
