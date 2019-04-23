package com.spj.booksms.filter;

import com.spj.booksms.tools.JwtUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import static com.spj.booksms.tools.JwtUtil.ROLE;


public class JwtAuthenticationFilter extends OncePerRequestFilter {

    /**
     * AntPathMatcher()可以做URLs匹配，规则如下
     * ？匹配一个字符
     * *匹配0个或多个字符
     * **匹配0个或多个目录
     */
    private static final PathMatcher pathmatcher = new AntPathMatcher();
    //  定义需要校验(过滤）的URL 下面定义的路径都需要进行token校验
    private String[] protectUrlPattern = {"/manage/**", "/member/**", "/auth/**","/alipay/**"};

    public JwtAuthenticationFilter() {

    }

    //校验器
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException,
            IOException {




//        try {
//            10             // request就是第一步，使用name和password封装成为的token
//            11             Authentication request = new UsernamePasswordAuthenticationToken(name, password);
//            12             // 将token传递给Authentication进行验证
//            13             Authentication result = am.authenticate(request);
//            14             SecurityCont`extHolder.getContext().setAuthentication(result);
//            15             break;
//            16         } catch (AuthenticationException e) {
//            17             System.out.println("认证失败：" + e.getMessage());
//            18         }

        try {
            if (isProtectedUrl(httpServletRequest)) {
                Map<String, Object> claims = JwtUtil.validateTokenAndGetClaims(httpServletRequest);
                String role = String.valueOf(claims.get(ROLE));//获取注入到jwt中的角色
                String userid = String.valueOf(claims.get("userid"));//获取注入到jwt中的用户主键
                //最关键的部分就是这里, 我们直接注入了 （token校验）
                SecurityContextHolder.getContext().setAuthentication(
                        new UsernamePasswordAuthenticationToken(
                                userid, null, Arrays.asList(() -> role)
                        ));

            } else{
//                throw new Exception("不是过滤内容");
            }
        } catch (Exception e) {
            e.printStackTrace();
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
            return;
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);


    }

    //url效验
    private boolean isProtectedUrl(HttpServletRequest request) {

        for (int i = 0; i < protectUrlPattern.length; i++) {
            if (pathmatcher.match(protectUrlPattern[i], request.getServletPath())) {
                return true;
            }
        }
        return false;
    }

}