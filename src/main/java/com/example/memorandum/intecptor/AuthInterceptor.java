package com.example.memorandum.intecptor;

import com.alibaba.fastjson2.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.memorandum.common.Result;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Yeah
 * @create 2022/9/15
 */
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("进入拦截器……");

        //从请求体获取到token
        String token = request.getHeader("Authorization");
        System.out.println("token是："+token);

        //设置字符集编码
        response.setContentType("application/json;charset=utf8");

        //如果token为null直接返回false
        if (token == null){
            response.getWriter().write(JSON.toJSONString(Result.error("token不能为空")));
            return false;
        }

        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("ahkjsfhas")).build();

        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            response.getWriter().write(JSON.toJSONString(Result.error("token不合法")));
            return false;
        }

        return true;
    }
}
