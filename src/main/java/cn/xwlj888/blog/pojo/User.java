package cn.xwlj888.blog.pojo;

import java.util.Date;
import javax.persistence.*;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    private String username;

    /**
     * 角色
     */
    private String role;

    private String email;

    private String phone;

    @Column(name = "createTime")
    private Date createtime;

    @Column(name = "updateTime")
    private Date updatetime;

    @Column(name = "editCount")
    private Integer editcount;

    private String note;

    @Column(name = "lastTime")
    private Date lasttime;

    @Column(name = "lastIp")
    private String lastip;

    private Integer logined;

    private String password;

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
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取角色
     *
     * @return role - 角色
     */
    public String getRole() {
        return role;
    }

    /**
     * 设置角色
     *
     * @param role 角色
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return createTime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * @return updateTime
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * @param updatetime
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * @return editCount
     */
    public Integer getEditcount() {
        return editcount;
    }

    /**
     * @param editcount
     */
    public void setEditcount(Integer editcount) {
        this.editcount = editcount;
    }

    /**
     * @return note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return lastTime
     */
    public Date getLasttime() {
        return lasttime;
    }

    /**
     * @param lasttime
     */
    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }

    /**
     * @return lastIp
     */
    public String getLastip() {
        return lastip;
    }

    /**
     * @param lastip
     */
    public void setLastip(String lastip) {
        this.lastip = lastip;
    }

    /**
     * @return logined
     */
    public Integer getLogined() {
        return logined;
    }

    /**
     * @param logined
     */
    public void setLogined(Integer logined) {
        this.logined = logined;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}