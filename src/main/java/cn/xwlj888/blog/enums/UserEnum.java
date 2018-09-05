package cn.xwlj888.blog.enums;

/**
 * @author
 * @create 2018-08-22 21:22
 **/
public enum UserEnum {
    /**
     * admin
     */
    ROLE("role","role"),
    USERNAME("userName",""),
    UUID("uuid",""),
    RE("R","RE"),
    ADMIN("A","A"),
    LASTLOGINTIME("lastTime",""),
    LOGINED("logined","LOGINED"),
    LASTLOGINIP("lastIp","");


    private String code;
    private String name;

    UserEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
