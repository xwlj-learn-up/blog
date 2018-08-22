package cn.xwlj888.blog.pojo;

import javax.persistence.*;

public class Keyword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * �ؼ���
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
     * ��ȡ�ؼ���
     *
     * @return value - �ؼ���
     */
    public String getValue() {
        return value;
    }

    /**
     * ���ùؼ���
     *
     * @param value �ؼ���
     */
    public void setValue(String value) {
        this.value = value;
    }
}