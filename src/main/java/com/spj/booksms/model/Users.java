package com.spj.booksms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Users {
    private String uid;
    private String username;
    private String upwd;
    private Long umobile;
    private Short udiscounts;
    private String ugrade;
    private String urole;
    private String uaddress;

    @Id
    @GeneratedValue(generator = "uuid2" )   //指定生成器名称
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator" )  //生成器名称，uuid生成类

    @Column(name = "uid")
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "upwd")
    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    @Basic
    @Column(name = "umobile")
    public Long getUmobile() {
        return umobile;
    }

    public void setUmobile(Long umobile) {
        this.umobile = umobile;
    }

    @Basic
    @Column(name = "udiscounts")
    public Short getUdiscounts() {
        return udiscounts;
    }

    public void setUdiscounts(Short udiscounts) {
        this.udiscounts = udiscounts;
    }

    @Basic
    @Column(name = "ugrade")
    public String getUgrade() {
        return ugrade;
    }

    public void setUgrade(String ugrade) {
        this.ugrade = ugrade;
    }

    @Basic
    @Column(name = "urole")
    public String getUrole() {
        return urole;
    }

    public void setUrole(String urole) {
        this.urole = urole;
    }

    @Basic
    @Column(name = "uaddress")
    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(uid, users.uid) &&
                Objects.equals(username, users.username) &&
                Objects.equals(upwd, users.upwd) &&
                Objects.equals(umobile, users.umobile) &&
                Objects.equals(udiscounts, users.udiscounts) &&
                Objects.equals(ugrade, users.ugrade) &&
                Objects.equals(urole, users.urole) &&
                Objects.equals(uaddress, users.uaddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, username, upwd, umobile, udiscounts, ugrade, urole, uaddress);
    }
}
