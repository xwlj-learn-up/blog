package cn.xwlj888.blog.enums;

public enum FileTypeEnum {
    /**
     * word文档
     */
    DOC("doc","word文档后缀"),
    DOCX("docx","word文档后缀"),
    PNG("png",""),
    GIF("gif",""),
    JPEG("jpeg","");
    private String code;
    private String name;

    private FileTypeEnum(String code,String name){
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
