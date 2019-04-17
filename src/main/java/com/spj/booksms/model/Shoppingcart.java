package com.spj.booksms.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Shoppingcart {
    private String sid;
    private String pstatus;
    private Long quantity;
    private String productid;
    private Float totalcost;

    @Id
    @GeneratedValue(generator = "uuid2" )   //指定生成器名称
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator" )  //生成器名称，uuid生成类

    @Column(name = "sid")
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "pstatus")
    public String getPstatus() {
        return pstatus;
    }

    public void setPstatus(String pstatus) {
        this.pstatus = pstatus;
    }

    @Basic
    @Column(name = "quantity")
    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "productid")
    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    @Basic
    @Column(name = "totalcost")
    public Float getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(Float totalcost) {
        this.totalcost = totalcost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shoppingcart that = (Shoppingcart) o;
        return Objects.equals(sid, that.sid) &&
                Objects.equals(pstatus, that.pstatus) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(productid, that.productid) &&
                Objects.equals(totalcost, that.totalcost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, pstatus, quantity, productid, totalcost);
    }
}
