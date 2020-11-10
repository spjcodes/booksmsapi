package com.spj.booksms.action;


import com.spj.booksms.model.*;
import com.spj.booksms.service.ManageService;
import com.spj.booksms.tools.JwtUtil;
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
@RequestMapping("public")
@CrossOrigin
public class PublicAction
{
    @Autowired
    private ManageService manageService;

    @PostMapping("login")
    @ResponseBody
    public HashMap login(@RequestBody Users users){
        HashMap map = new HashMap();
        Users user = manageService.queryUserByUsernameAndPassword(users.getUsername(), users.getUpwd());

        System.out.println(".......................................");
        System.out.println("user:" + user);

        if(user != null){
            String token = JwtUtil.generateToken(user.getUrole(), user.getUid());
            map.put("msg", "ok");
            map.put("token", token);
        } else{
            map.put("msg", "erro");
        }
        return map;
    }

    @PostMapping("getuser")
    @ResponseBody
    public Users getuser(@RequestBody Users users){
        return manageService.queryUserByUsernameAndPassword(users.getUsername(), users.getUpwd());
    }


    @PostMapping("getUser")
    @ResponseBody
    public Users getUser(@RequestBody Users users){
        return manageService.queryUser(users.getUid());
    }

    @GetMapping("getUserList")
    @ResponseBody
    public List<Users> getUserList(){
        return manageService.queryUserList();
    }

    @PostMapping("getBooksBySolrEngine")
    @ResponseBody
    public List<Book> getBooksBySolrEngine( String keyWorld){
        return manageService.getBooksBySolrEngine(keyWorld);
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


    @PostMapping("getBookListByBstype")
    @ResponseBody
    public List getBookListByBstype (@RequestBody Book book){
        return this.manageService.queryBooksByBstype(book.getBstype());
    }

    @PostMapping("getBooksListByType")
    @ResponseBody
    public List getBooksListByType(@RequestBody Book book){
        return manageService.queryBookListByType(book.getBtype());
    }

    @PostMapping("deleteOrderFormById")
    @ResponseBody
    public boolean deleteOrderForm(@RequestBody Orderform orderform){
        return manageService.deleteOrderForm(orderform.getOid());
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

    @PostMapping("getOrderFormListByUser")
    @ResponseBody
    public List<Orderform> getOrderFormListByUser(@RequestBody Orderform orderform){
        return manageService.getOrderFormListByUser(orderform.getOpurchaser());
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
        String filePath = "d:/booksmsFiles/";
        File tf = new File(filePath);
        if(!tf.exists()){
            tf.mkdir();
            System.out.println("创建文件夹成功");
        }
        try {
            //将内存中的文件写入磁盘
            uploadfile.transferTo(new File(filePath+ newfile));
            m.put("cimg",newfile);
            System.out.println("新文件名为：" + newfile);
            return m;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping("ckeditorUpload")
    @ResponseBody
    public String ckeditorUpload(@RequestParam("upload") MultipartFile file, String CKEditorFuncNum) throws Exception {
        if (!file.isEmpty()) {
            String finename=file.getOriginalFilename();
            String suffixname=file.getOriginalFilename().substring(finename.lastIndexOf("."));
            finename=String.valueOf(System.currentTimeMillis())+suffixname;
            String filepath="d:/booksmsFiles/";
            File tf=new File(filepath);
            if(!tf.exists()){
                tf.mkdir();
            }
            String savefile=filepath+finename;
            try {
                file.transferTo(new File(savefile));
                String url="http://localhost:8081/"+finename;
                return "{\"uploaded\":1,\"fileName\":\""+savefile+"\",\"url\":\"" + url + "\"}";
            } catch (IOException e) {
                e.printStackTrace();
                return "{\"uploaded\":0,\"error\":{\"message\":\"upload file is not success!\"}}";

            } catch (IllegalStateException e) {
                e.printStackTrace();
                return "{\"uploaded\":0,\"error\":{\"message\":\"upload file is not success!\"}}";
            }
        }
        return "{\"uploaded\":0,\"error\":{\"message\":\"upload file is not success!\"}}";
    }






}



