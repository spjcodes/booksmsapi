package com.spj.booksms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Orderform {
    private String oid;
    private String obook;
    private Short  ocost;
    //供应商
    private String ovendor;
    //购买者
    private String  opurchaser;
    private  Long   obuytime;

    @Id
    @GeneratedValue(generator = "uuid2" )   //指定生成器名称
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator" )  //生成器名称，uuid生成类

    @Column(name = "oid")
    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    @Basic
    @Column(name = "obook")
    public String getObook() {
        return obook;
    }

    public void setObook(String obook) {
        this.obook = obook;
    }

    @Basic
    @Column(name = "ocost")
    public Short getOcost() {
        return ocost;
    }

    public void setOcost(Short ocost) {
        this.ocost = ocost;
    }

    @Basic
    @Column(name = "ovendor")
    public String getOvendor() {
        return ovendor;
    }

    public void setOvendor(String ovendor) {
        this.ovendor = ovendor;
    }

    @Basic
    @Column(name = "opurchaser")
    public String getOpurchaser() {
        return opurchaser;
    }

    public void setOpurchaser(String opurchaser) {
        this.opurchaser = opurchaser;
    }

    @Basic
    @Column(name = "obuytime")
    public Long getObuytime() {
        return obuytime;
    }

    public void setObuytime(Long obuytime) {
        this.obuytime = obuytime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orderform orderform = (Orderform) o;
        return Objects.equals(oid, orderform.oid) &&
                Objects.equals(obook, orderform.obook) &&
                Objects.equals(ocost, orderform.ocost) &&
                Objects.equals(ovendor, orderform.ovendor) &&
                Objects.equals(opurchaser, orderform.opurchaser) &&
                Objects.equals(obuytime, orderform.obuytime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oid, obook, ocost, ovendor, opurchaser, obuytime);
    }
}
