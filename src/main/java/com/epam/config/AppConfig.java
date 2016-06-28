package com.epam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.*;

import javax.annotation.PostConstruct;

@Configuration
@EnableWebMvc
@ComponentScan
public class AppConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

//        registry.addResourceHandler("/app/angular/**")
//                .addResourceLocations("classpath:/app/angular/convert.js");
//        registry
//                .addResourceHandler("/app/**")
//                .addResourceLocations("classpath:/app/index.html");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CORSFilter());
    }

}
