package cn.xwlj888.blog.pojo;

import java.util.Date;
import javax.persistence.*;

public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    @Column(name = "chiContent")
    private String chicontent;

    @Column(name = "engContent")
    private String engcontent;

    private Date date;

    private String author;

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
     * @return chiContent
     */
    public String getChicontent() {
        return chicontent;
    }

    /**
     * @param chicontent
     */
    public void setChicontent(String chicontent) {
        this.chicontent = chicontent;
    }

    /**
     * @return engContent
     */
    public String getEngcontent() {
        return engcontent;
    }

    /**
     * @param engcontent
     */
    public void setEngcontent(String engcontent) {
        this.engcontent = engcontent;
    }

    /**
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }
}