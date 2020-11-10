package com.spj.booksms.dao;

import com.spj.booksms.model.Orderform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderFormDao extends JpaRepository<Orderform, String> {

    @Query("select o from Orderform  o where o.opurchaser=:id")
    List<Orderform> getOrderFormListByUser(@Param("id") String id);
}
