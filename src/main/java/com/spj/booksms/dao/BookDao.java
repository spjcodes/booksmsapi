package com.spj.booksms.dao;

import com.spj.booksms.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookDao extends JpaRepository<Book, String> {
    @Query("select b from Book b where b.btype=:btype")
    List<Book> getBooksByType(@Param("btype") String btype) ;
}
