package cn.xwlj888.blog.pojo;

import java.util.Date;
import javax.persistence.*;

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * ����ID
     */
    @Column(name = "contentId")
    private Integer contentid;

    /**
     * ����
     */
    private String title;

    /**
     * ����
     */
    private String abstr;

    /**
     * ���
     */
    @Column(name = "categoryId")
    private String categoryid;

    @Column(name = "categoryValue")
    private String categoryvalue;

    /**
     * ͼƬ��ַ
     */
    private String imgurl;

    /**
     * ��������
     */
    @Column(name = "createDate")
    private Date createdate;

    /**
     * 1Ϊ��������
     */
    private String top;

    /**
     * �ؼ���
     */
    private String key;

    @Column(name = "keyValue")
    private String keyvalue;

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
     * ��ȡ����ID
     *
     * @return contentId - ����ID
     */
    public Integer getContentid() {
        return contentid;
    }

    /**
     * ��������ID
     *
     * @param contentid ����ID
     */
    public void setContentid(Integer contentid) {
        this.contentid = contentid;
    }

    /**
     * ��ȡ����
     *
     * @return title - ����
     */
    public String getTitle() {
        return title;
    }

    /**
     * ���ñ���
     *
     * @param title ����
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * ��ȡ����
     *
     * @return abstr - ����
     */
    public String getAbstr() {
        return abstr;
    }

    /**
     * ��������
     *
     * @param abstr ����
     */
    public void setAbstr(String abstr) {
        this.abstr = abstr;
    }

    /**
     * ��ȡ���
     *
     * @return categoryId - ���
     */
    public String getCategoryid() {
        return categoryid;
    }

    /**
     * �������
     *
     * @param categoryid ���
     */
    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    /**
     * @return categoryValue
     */
    public String getCategoryvalue() {
        return categoryvalue;
    }

    /**
     * @param categoryvalue
     */
    public void setCategoryvalue(String categoryvalue) {
        this.categoryvalue = categoryvalue;
    }

    /**
     * ��ȡͼƬ��ַ
     *
     * @return imgurl - ͼƬ��ַ
     */
    public String getImgurl() {
        return imgurl;
    }

    /**
     * ����ͼƬ��ַ
     *
     * @param imgurl ͼƬ��ַ
     */
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    /**
     * ��ȡ��������
     *
     * @return createDate - ��������
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * ���ô�������
     *
     * @param createdate ��������
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * ��ȡ1Ϊ��������
     *
     * @return top - 1Ϊ��������
     */
    public String getTop() {
        return top;
    }

    /**
     * ����1Ϊ��������
     *
     * @param top 1Ϊ��������
     */
    public void setTop(String top) {
        this.top = top;
    }

    /**
     * ��ȡ�ؼ���
     *
     * @return key - �ؼ���
     */
    public String getKey() {
        return key;
    }

    /**
     * ���ùؼ���
     *
     * @param key �ؼ���
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return keyValue
     */
    public String getKeyvalue() {
        return keyvalue;
    }

    /**
     * @param keyvalue
     */
    public void setKeyvalue(String keyvalue) {
        this.keyvalue = keyvalue;
    }
}