package cn.xwlj888.blog.pojo;

import java.util.Date;
import javax.persistence.*;

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * ��������
     */
    private String content;

    /**
     * ����ID
     */
    @Column(name = "articleId")
    private String articleid;

    /**
     * ����ʱ��
     */
    private Date date;

    /**
     * ���۵�IP��ַ
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
     * ��ȡ��������
     *
     * @return content - ��������
     */
    public String getContent() {
        return content;
    }

    /**
     * ������������
     *
     * @param content ��������
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * ��ȡ����ID
     *
     * @return articleId - ����ID
     */
    public String getArticleid() {
        return articleid;
    }

    /**
     * ��������ID
     *
     * @param articleid ����ID
     */
    public void setArticleid(String articleid) {
        this.articleid = articleid;
    }

    /**
     * ��ȡ����ʱ��
     *
     * @return date - ����ʱ��
     */
    public Date getDate() {
        return date;
    }

    /**
     * ��������ʱ��
     *
     * @param date ����ʱ��
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * ��ȡ���۵�IP��ַ
     *
     * @return ip - ���۵�IP��ַ
     */
    public String getIp() {
        return ip;
    }

    /**
     * �������۵�IP��ַ
     *
     * @param ip ���۵�IP��ַ
     */
    public void setIp(String ip) {
        this.ip = ip;
    }
}