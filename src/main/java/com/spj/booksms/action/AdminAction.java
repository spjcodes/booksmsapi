package com.spj.booksms.action;

import com.spj.booksms.model.*;
import com.spj.booksms.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    @PostMapping("updateUser")
    @ResponseBody
    public boolean updateUser(@RequestBody Users users){
        return manageService.update(users);
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




    @PostMapping("addCarousel")
    @ResponseBody
    public boolean addCarousel(@RequestBody Carousel carousel){
        return manageService.addCarousel(carousel);
    }

    @PostMapping("deleteCarousel")
    @ResponseBody
    public boolean deleteCarouel(@RequestBody Carousel carousel){
        return manageService.deleteCarousel(carousel.getCid());
    }

    @PostMapping("updateCarouel")
    @ResponseBody
    public boolean updateCarousel(@RequestBody Carousel carousel){
        return manageService.updateCarousel(carousel);
    }





    @PostMapping("addHotrecommend")
    @ResponseBody
    public boolean addHotrecommend(@RequestBody Hotrecommend hotrecommend){
        return manageService.addHotrecommend(hotrecommend);
    }

    @PostMapping("deleteHotrecommend")
    @ResponseBody
    public boolean deleteHotrecommend(@RequestBody Hotrecommend hotrecommend){
        return manageService.deleteHotrecommend(hotrecommend.getHid());
    }

    @PostMapping("updateHotrecommend")
    @ResponseBody
    public boolean updateHotrecommend(@RequestBody Hotrecommend hotrecommend){
        return manageService.updateHotrecommend(hotrecommend);
    }



}
