package cn.xwlj888.blog.pojo;

import java.util.Date;
import javax.persistence.*;

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 内容ID
     */
    @Column(name = "contentId")
    private Integer contentid;

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String abstr;

    /**
     * 类别
     */
    @Column(name = "categoryId")
    private String categoryid;

    @Column(name = "categoryValue")
    private String categoryvalue;

    /**
     * 图片地址
     */
    private String imgurl;

    /**
     * 创建日期
     */
    @Column(name = "createDate")
    private Date createdate;

    /**
     * 1为热门文章
     */
    private String top;

    /**
     * 关键字
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
     * 获取内容ID
     *
     * @return contentId - 内容ID
     */
    public Integer getContentid() {
        return contentid;
    }

    /**
     * 设置内容ID
     *
     * @param contentid 内容ID
     */
    public void setContentid(Integer contentid) {
        this.contentid = contentid;
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取描述
     *
     * @return abstr - 描述
     */
    public String getAbstr() {
        return abstr;
    }

    /**
     * 设置描述
     *
     * @param abstr 描述
     */
    public void setAbstr(String abstr) {
        this.abstr = abstr;
    }

    /**
     * 获取类别
     *
     * @return categoryId - 类别
     */
    public String getCategoryid() {
        return categoryid;
    }

    /**
     * 设置类别
     *
     * @param categoryid 类别
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
     * 获取图片地址
     *
     * @return imgurl - 图片地址
     */
    public String getImgurl() {
        return imgurl;
    }

    /**
     * 设置图片地址
     *
     * @param imgurl 图片地址
     */
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    /**
     * 获取创建日期
     *
     * @return createDate - 创建日期
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置创建日期
     *
     * @param createdate 创建日期
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取1为热门文章
     *
     * @return top - 1为热门文章
     */
    public String getTop() {
        return top;
    }

    /**
     * 设置1为热门文章
     *
     * @param top 1为热门文章
     */
    public void setTop(String top) {
        this.top = top;
    }

    /**
     * 获取关键字
     *
     * @return key - 关键字
     */
    public String getKey() {
        return key;
    }

    /**
     * 设置关键字
     *
     * @param key 关键字
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