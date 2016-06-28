package com.epam.config;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by tt on 27-Jun-16.
 */
public class CORSFilter extends HandlerInterceptorAdapter {

    public static final String CREDENTIALS_NAME = "Access-Control-Allow-Credentials";
    public static final String ORIGIN_NAME = "Access-Control-Allow-Origin";
    public static final String METHODS_NAME = "Access-Control-Allow-Methods";
    public static final String HEADERS_NAME = "Access-Control-Allow-Headers";
    public static final String MAX_AGE_NAME = "Access-Control-Max-Age";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        response.setHeader(CREDENTIALS_NAME, "true");
        response.setHeader(ORIGIN_NAME, "http://localhost:3000");
        response.setHeader(METHODS_NAME, "GET, OPTIONS, POST, PUT, DELETE");
        response.setHeader(HEADERS_NAME, "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader(MAX_AGE_NAME, "3600");

        return super.preHandle(request, response, handler);
    }
}
