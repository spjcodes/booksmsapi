package com.spj.booksms.dao;

import com.spj.booksms.model.Shoppingcart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingcartDao extends JpaRepository<Shoppingcart, String> {


}
