package com.spj.booksms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Hotrecommend {
    private String hid;
    private String hname;
    private Short hstar;
    private String himage;
    private String hintro;

    @Id
    @GeneratedValue(generator = "uuid2" )   //指定生成器名称
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator" )  //生成器名称，uuid生成类

    @Column(name = "hid")
    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    @Basic
    @Column(name = "hname")
    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    @Basic
    @Column(name = "hstar")
    public Short getHstar() {
        return hstar;
    }

    public void setHstar(Short hstar) {
        this.hstar = hstar;
    }

    @Basic
    @Column(name = "himage")
    public String getHimage() {
        return himage;
    }

    public void setHimage(String himage) {
        this.himage = himage;
    }

    @Basic
    @Column(name = "hintro")
    public String getHintro() {
        return hintro;
    }

    public void setHintro(String hintro) {
        this.hintro = hintro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotrecommend that = (Hotrecommend) o;
        return Objects.equals(hid, that.hid) &&
                Objects.equals(hname, that.hname) &&
                Objects.equals(hstar, that.hstar) &&
                Objects.equals(himage, that.himage) &&
                Objects.equals(hintro, that.hintro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hid, hname, hstar, himage, hintro);
    }
}
