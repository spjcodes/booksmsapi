package com.spj.booksms.dao;

import com.spj.booksms.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UsersDao  extends JpaRepository<Users, String> {
    @Query("select u from Users u where u.username=:username and u.upwd=:upwd")
    public Users findUserByUsernameAndPassword(@Param("username") String username,
                                               @Param("upwd") String upwd);


    @Query("select u.uid from Users  u where u.username=:username and u.upwd=:upwd")
    String getUerIdByUserInfo(@Param("username") String username,
                              @Param("upwd") String upwd);
}

