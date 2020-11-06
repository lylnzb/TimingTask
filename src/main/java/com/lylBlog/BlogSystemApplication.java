package com.lylBlog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.lylBlog.**.mapper")
@ServletComponentScan
public class BlogSystemApplication {
    public static void main(String[] args){
        SpringApplication.run(BlogSystemApplication.class, args);
    }
}
