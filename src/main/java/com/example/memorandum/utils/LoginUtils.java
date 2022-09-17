package com.example.memorandum.utils;

import com.auth0.jwt.JWT;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Yeah
 * @create 2022/9/15
 */
public class LoginUtils {

    public static Integer UserId(HttpServletRequest request){

        String token = request.getHeader("Authorization");
        String id = JWT.decode(token).getAudience().get(0);

        return (Integer.valueOf(id));


    }

}
