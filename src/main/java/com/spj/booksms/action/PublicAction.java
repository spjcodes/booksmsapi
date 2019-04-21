package com.spj.booksms.action;


import com.spj.booksms.model.Users;
import com.spj.booksms.service.ManageService;
import com.spj.booksms.tools.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@CrossOrigin
@RequestMapping("public")
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

}
