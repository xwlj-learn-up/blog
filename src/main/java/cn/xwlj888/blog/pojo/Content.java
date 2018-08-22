package cn.xwlj888.blog.pojo;

import javax.persistence.*;

public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * ����
     */
    private String content;

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
     * ��ȡ����
     *
     * @return content - ����
     */
    public String getContent() {
        return content;
    }

    /**
     * ��������
     *
     * @param content ����
     */
    public void setContent(String content) {
        this.content = content;
    }
}