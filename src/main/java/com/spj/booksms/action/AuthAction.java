package com.spj.booksms.action;

import com.spj.booksms.model.Users;
import com.spj.booksms.service.ManageService;
import com.spj.booksms.tools.AuthTools;
import com.spj.booksms.tools.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("auth")
public class AuthAction {

    @Autowired
    private ManageService manageService;


    @GetMapping("refreshToken")
    @ResponseBody
    public HashMap<String, String> refreshToken(HttpServletRequest httpServletRequest) throws Exception {

        String userid = manageService.getCurrentUserId();
        String roleid = manageService.getCurrentUserRole();
        if (AuthTools.isNullOrSpace(userid) && AuthTools.isNullOrSpace(roleid)) {

            return new HashMap<String, String>() {{
                put("token", "error");
            }};

        } else {
            String token = JwtUtil.generateToken(roleid, userid);

            return new HashMap<String, String>() {{
                put("token", token);
            }};

        }

    }


    @PostMapping("getUserIdByUserInfo")
    @ResponseBody
    public HashMap getUserIdByUserInfo(@RequestBody Users users) {
        String id = this.manageService.getUserIdByUserInfo(users);
        return new HashMap() {{
            put("id", id);
        }};
    }

    @GetMapping("getRole")
    @ResponseBody
    public HashMap getRole() throws Exception {

        String role = manageService.getCurrentUserRole();
        if (AuthTools.isNullOrSpace(role)) {

            return new HashMap() {{
                put("role", "error");
            }};

        } else {
            return new HashMap() {{
                put("role", role);
            }};

        }


    }
}
