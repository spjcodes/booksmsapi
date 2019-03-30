package com.spj.booksms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Book {
    private String bid;
    private String bname;
    private String bauthor;
    private String bversion;
    private String bimage;
    private Short boldcost;
    private Short bnewcost;
    private String bintro;
    private String btype;
    private Short bstar;

    @Id
    @GeneratedValue(generator = "uuid2" )   //指定生成器名称
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator" )  //生成器名称，uuid生成类

    @Column(name = "bid")
    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    @Basic
    @Column(name = "bname")
    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    @Basic
    @Column(name = "bauthor")
    public String getBauthor() {
        return bauthor;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    @Basic
    @Column(name = "bversion")
    public String getBversion() {
        return bversion;
    }

    public void setBversion(String bversion) {
        this.bversion = bversion;
    }

    @Basic
    @Column(name = "bimage")
    public String getBimage() {
        return bimage;
    }

    public void setBimage(String bimage) {
        this.bimage = bimage;
    }

    @Basic
    @Column(name = "boldcost")
    public Short getBoldcost() {
        return boldcost;
    }

    public void setBoldcost(Short boldcost) {
        this.boldcost = boldcost;
    }

    @Basic
    @Column(name = "bnewcost")
    public Short getBnewcost() {
        return bnewcost;
    }

    public void setBnewcost(Short bnewcost) {
        this.bnewcost = bnewcost;
    }

    @Basic
    @Column(name = "bintro")
    public String getBintro() {
        return bintro;
    }

    public void setBintro(String bintro) {
        this.bintro = bintro;
    }

    @Basic
    @Column(name = "btype")
    public String getBtype() {
        return btype;
    }

    public void setBtype(String btype) {
        this.btype = btype;
    }

    @Basic
    @Column(name = "bstar")
    public Short getBstar() {
        return bstar;
    }

    public void setBstar(Short bstar) {
        this.bstar = bstar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bid, book.bid) &&
                Objects.equals(bname, book.bname) &&
                Objects.equals(bauthor, book.bauthor) &&
                Objects.equals(bversion, book.bversion) &&
                Objects.equals(bimage, book.bimage) &&
                Objects.equals(boldcost, book.boldcost) &&
                Objects.equals(bnewcost, book.bnewcost) &&
                Objects.equals(bintro, book.bintro) &&
                Objects.equals(btype, book.btype) &&
                Objects.equals(bstar, book.bstar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bid, bname, bauthor, bversion, bimage, boldcost, bnewcost, bintro, btype, bstar);
    }
}
