package cn.xwlj888.blog.pojo;

import java.util.Date;
import javax.persistence.*;

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 文章ID
     */
    @Column(name = "articleId")
    private String articleid;

    /**
     * 评论时间
     */
    private Date date;

    /**
     * 评论的IP地址
     */
    private String ip;

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
     * 获取评论内容
     *
     * @return content - 评论内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置评论内容
     *
     * @param content 评论内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取文章ID
     *
     * @return articleId - 文章ID
     */
    public String getArticleid() {
        return articleid;
    }

    /**
     * 设置文章ID
     *
     * @param articleid 文章ID
     */
    public void setArticleid(String articleid) {
        this.articleid = articleid;
    }

    /**
     * 获取评论时间
     *
     * @return date - 评论时间
     */
    public Date getDate() {
        return date;
    }

    /**
     * 设置评论时间
     *
     * @param date 评论时间
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 获取评论的IP地址
     *
     * @return ip - 评论的IP地址
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置评论的IP地址
     *
     * @param ip 评论的IP地址
     */
    public void setIp(String ip) {
        this.ip = ip;
    }
}