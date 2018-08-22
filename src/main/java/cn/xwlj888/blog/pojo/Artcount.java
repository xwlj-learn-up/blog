package cn.xwlj888.blog.pojo;

import javax.persistence.*;

public class Artcount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 点击量
     */
    private Integer click;

    /**
     * 评论量
     */
    private Integer comment;

    /**
     * 文章ID
     */
    @Column(name = "articleId")
    private Integer articleid;

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
     * 获取点击量
     *
     * @return click - 点击量
     */
    public Integer getClick() {
        return click;
    }

    /**
     * 设置点击量
     *
     * @param click 点击量
     */
    public void setClick(Integer click) {
        this.click = click;
    }

    /**
     * 获取评论量
     *
     * @return comment - 评论量
     */
    public Integer getComment() {
        return comment;
    }

    /**
     * 设置评论量
     *
     * @param comment 评论量
     */
    public void setComment(Integer comment) {
        this.comment = comment;
    }

    /**
     * 获取文章ID
     *
     * @return articleId - 文章ID
     */
    public Integer getArticleid() {
        return articleid;
    }

    /**
     * 设置文章ID
     *
     * @param articleid 文章ID
     */
    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }
}