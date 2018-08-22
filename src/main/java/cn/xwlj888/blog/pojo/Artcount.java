package cn.xwlj888.blog.pojo;

import javax.persistence.*;

public class Artcount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * �����
     */
    private Integer click;

    /**
     * ������
     */
    private Integer comment;

    /**
     * ����ID
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
     * ��ȡ�����
     *
     * @return click - �����
     */
    public Integer getClick() {
        return click;
    }

    /**
     * ���õ����
     *
     * @param click �����
     */
    public void setClick(Integer click) {
        this.click = click;
    }

    /**
     * ��ȡ������
     *
     * @return comment - ������
     */
    public Integer getComment() {
        return comment;
    }

    /**
     * ����������
     *
     * @param comment ������
     */
    public void setComment(Integer comment) {
        this.comment = comment;
    }

    /**
     * ��ȡ����ID
     *
     * @return articleId - ����ID
     */
    public Integer getArticleid() {
        return articleid;
    }

    /**
     * ��������ID
     *
     * @param articleid ����ID
     */
    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }
}