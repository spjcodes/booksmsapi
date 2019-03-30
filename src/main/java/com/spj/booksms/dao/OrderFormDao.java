package com.spj.booksms.dao;

import com.spj.booksms.model.Orderform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderFormDao extends JpaRepository<Orderform, String> {
}
