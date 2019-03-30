package com.spj.booksms.service.Impl;

import com.spj.booksms.dao.BookDao;
import com.spj.booksms.dao.OrderFormDao;
import com.spj.booksms.dao.UsersDao;
import com.spj.booksms.model.Book;
import com.spj.booksms.model.Orderform;
import com.spj.booksms.model.Users;
import com.spj.booksms.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private OrderFormDao orderFormDao;

    @Override
    public boolean update(Users users) {
        try {
            usersDao.save(users);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addBook(Book book) {
        try {
            bookDao.save(book);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteBook(String id) {
        try {
            bookDao.delete(bookDao.getOne(id));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateBook(Book book) {
        try {
            bookDao.save(book);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Book queryBook(String id) {
        try {
            return bookDao.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> queryBookList() {
        try {
            return bookDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addOrderForm(Orderform orderform) {
        try {
            orderFormDao.save(orderform);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteOrderForm(String id) {
        try {
            orderFormDao.delete(orderFormDao.getOne(id));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateOrderForm(Orderform orderform) {
        try {
            orderFormDao.save(orderform);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Orderform queryOrderForm(String id) {
        try {
            return orderFormDao.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Orderform> queryOrderFormList() {
        try {
            return orderFormDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteUser(String id) {
        try {
            usersDao.delete(usersDao.getOne(id));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Users queryUser(String id) {
        try {
            return usersDao.getOne(id);
        } catch (Exception e) {
            System.out.println("查询单个用户出错！！");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Users> queryUserList() {
        try {
            return usersDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addUser(Users users) {
        try {
            usersDao.save(users);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
