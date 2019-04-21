package com.spj.booksms.tools;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    private static final Logger logger= LoggerFactory.getLogger(JwtUtil.class);
    public static  final long EXPIRATION_TIME=7200_00;//6分钟
    public static final String SECRET="123456";
    public static final String TOKEN_PREFIX="Bearer";
    public static final String HEADER_STRING="Authorization";
    public static final String ROLE="ROLE";

    //生成jwtToken
    public static String generateToken(String userRole,String userid){
        return getString(userRole, userid, EXPIRATION_TIME);
    }

    private static String getString(String userRole, String userid, long expirationTime) {
        HashMap<String,Object> map=new HashMap<>();
        map.put(ROLE,userRole);
        map.put("userid",userid);
        String jwt= Jwts.builder()
                .setClaims(map)
                .setExpiration(new Date(System.currentTimeMillis()+ expirationTime))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        System.out.println("toke 生成。。。。............................................");
        System.out.println("token generate:" + jwt);
        return TOKEN_PREFIX+" "+jwt;
    }

    public static String generateToken(String userRole,String userid,long exprationtime){
        return getString(userRole, userid, exprationtime);
    }

    //token处理
    public static  Map<String,Object> validateTokenAndGetClaims(HttpServletRequest request){

        System.out.println("headAuthorization...................");
        System.out.println(request.getHeader(HEADER_STRING));

        String token=request.getHeader(HEADER_STRING);

        System.out.println("token" + token);

        if(token==null){
            throw new TokenValidationException("Messing Token");

        }
        else{
            Map<String,Object> body=Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX,""))
                    .getBody();
            return body;
        }
    }




    static class TokenValidationException extends RuntimeException{
        public TokenValidationException(String msg){
            super(msg);
        }
    }




}