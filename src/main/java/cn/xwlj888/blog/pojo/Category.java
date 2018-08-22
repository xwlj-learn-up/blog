package cn.xwlj888.blog.pojo;

import javax.persistence.*;

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 类别名称
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
     * 获取类别名称
     *
     * @return chiName - 类别名称
     */
    public String getChiname() {
        return chiname;
    }

    /**
     * 设置类别名称
     *
     * @param chiname 类别名称
     */
    public void setChiname(String chiname) {
        this.chiname = chiname;
    }
}