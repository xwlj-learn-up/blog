package cn.xwlj888.blog.pojo;

import javax.persistence.*;

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * �������
     */
    @Column(name = "chiName")
    private String chiname;

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
     * ��ȡ�������
     *
     * @return chiName - �������
     */
    public String getChiname() {
        return chiname;
    }

    /**
     * �����������
     *
     * @param chiname �������
     */
    public void setChiname(String chiname) {
        this.chiname = chiname;
    }
}