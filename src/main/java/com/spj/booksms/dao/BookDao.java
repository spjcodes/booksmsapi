package com.spj.booksms.dao;

import com.spj.booksms.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book, String> {
}
