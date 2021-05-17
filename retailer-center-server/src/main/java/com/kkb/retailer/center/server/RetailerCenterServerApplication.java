package com.kkb.retailer.center.server;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDubbo
@MapperScan("com.kkb.retailer.center.server.mappers")
public class RetailerCenterServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RetailerCenterServerApplication.class, args);
    }
}
