package com.spj.booksms.service;

import com.spj.booksms.model.Book;
import com.spj.booksms.model.Orderform;
import com.spj.booksms.model.Users;

import java.util.List;

public interface ManageService {
    public boolean addUser(Users users);
    public boolean update(Users users);
    public boolean deleteUser(String id);
    public Users queryUser(String id);
    public List<Users> queryUserList();

    public boolean addBook(Book book);
    public boolean deleteBook(String id);
    public boolean updateBook(Book book);
    public Book queryBook(String id);
    public List<Book> queryBookList();

    public boolean addOrderForm(Orderform orderform);
    public boolean deleteOrderForm(String id);
    public boolean updateOrderForm(Orderform orderform);
    public Orderform queryOrderForm(String id);
    public List<Orderform> queryOrderFormList();


}
