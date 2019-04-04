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

    @PostMapping("getBooksListByType")
    @ResponseBody
    public List getBooksListByType(@RequestBody Book book){
        return manageService.queryBookListByType(book.getBtype());
    }


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

    @PostMapping("getCarousel")
    @ResponseBody
    public Carousel getCarosuel(@RequestBody Carousel carousel){
        return manageService.queryCarosuel(carousel.getCid());
    }

    @GetMapping("getCarouselList")
    @ResponseBody
    public List<Carousel> getCarouselList(){
        return manageService.queryCarouselList();
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

    @PostMapping("getHotrecommend")
    @ResponseBody
    public Hotrecommend geetHotrecommend(@RequestBody Hotrecommend hotrecommend){
        return manageService.queryHotrecommend(hotrecommend.getHid());
    }

    @GetMapping("getHotrecommendList")
    @ResponseBody
    public List<Hotrecommend> getHotrecommendList(){
        return manageService.queryHotrecommendList();
    }


    @PostMapping("uploadPic")
    @ResponseBody
    public Map upLoadPic(MultipartFile uploadfile){
        Map m =  new HashMap();
        String filename = uploadfile.getOriginalFilename();
        System.out.println("收到的文件名为： "+filename);
        String suffixname = uploadfile.getOriginalFilename().substring(filename.lastIndexOf("."));
        String newfile = String.valueOf(System.currentTimeMillis())+ suffixname;
        String filePath = "d:/booksms/";
        File tf = new File(filePath);
        if(!tf.exists()){
            tf.mkdir();
        }

        try {
            //将内存中的文件写入磁盘
            uploadfile.transferTo(new File(filePath + newfile));
            m.put("pic",newfile);
            System.out.println("新文件名为：" + newfile);
            return m;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
