package com.spj.booksms.dao;

import com.spj.booksms.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UsersDao  extends JpaRepository<Users, String> {



}

