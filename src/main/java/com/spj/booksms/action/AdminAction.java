package com.spj.booksms.action;

import com.spj.booksms.model.Book;
import com.spj.booksms.model.Orderform;
import com.spj.booksms.model.Users;
import com.spj.booksms.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("manage")
public class AdminAction  {

    @Autowired
    private ManageService manageService;

    @PostMapping("addUser")
    @ResponseBody
    public boolean adduser(@RequestBody Users users){
       return manageService.addUser(users);
    }

    @PostMapping("deleteUser")
    @ResponseBody
    public boolean deleteUser(@RequestBody Users user){
        return manageService.deleteUser(user.getUid());
    }

    @PostMapping("getUser")
    @ResponseBody
    public Users getUser(@RequestBody Users users){
        return manageService.queryUser(users.getUid());
    }

    @PostMapping("updateUser")
    @ResponseBody
    public boolean updateUser(@RequestBody Users users){
        return manageService.update(users);
    }

    @GetMapping("getUserList")
    @ResponseBody
    public List<Users> getUserList(){
        return manageService.queryUserList();
    }



    @PostMapping("addBook")
    @ResponseBody
    public boolean addBook(@RequestBody Book book){
        return manageService.addBook(book);
    }

    @PostMapping("deleteBook")
    @ResponseBody
    public boolean deleteBook(@RequestBody Book book){
        return manageService.deleteBook(book.getBid());
    }

    @PostMapping("getBook")
    @ResponseBody
    public Book getBook(@RequestBody Book book){
        return manageService.queryBook(book.getBid());
    }

    @GetMapping("getBookList")
    @ResponseBody
    public List<Book> getBookList(){
        return manageService.queryBookList();
    }

    @PostMapping("updateBook")
    @ResponseBody
    public boolean updateBook(@RequestBody Book book){
        return manageService.updateBook(book);
    }




    @PostMapping("addOrderForm")
    @ResponseBody
    public boolean addOrderForm(@RequestBody Orderform orderform){
        return manageService.addOrderForm(orderform);
    }

    @PostMapping("deleteOrderForm")
    @ResponseBody
    public boolean deleteOrderForm(@RequestBody Orderform orderform){
        return manageService.deleteBook(orderform.getOid());
    }

    @PostMapping("updateOrderForm")
    @ResponseBody
    public boolean updateOrderForm(@RequestBody Orderform orderform){
        return manageService.updateOrderForm(orderform);
    }

    @PostMapping("getOrderForm")
    @ResponseBody
    public Orderform getOrderForm(@RequestBody Orderform orderform){
        return manageService.queryOrderForm(orderform.getOid());
    }

    @GetMapping("getOrderFormList")
    @ResponseBody
    public List<Orderform> getOrderForm(){
        return manageService.queryOrderFormList();
    }

}
