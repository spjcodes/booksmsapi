package com.spj.booksms.dao;

import com.spj.booksms.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDao  extends JpaRepository<Users, String> {
}
