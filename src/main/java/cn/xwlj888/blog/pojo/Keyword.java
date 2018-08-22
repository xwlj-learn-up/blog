package cn.xwlj888.blog.pojo;

import javax.persistence.*;

public class Keyword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 关键字
     */
    private String value;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取关键字
     *
     * @return value - 关键字
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置关键字
     *
     * @param value 关键字
     */
    public void setValue(String value) {
        this.value = value;
    }
}