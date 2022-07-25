package com.mouse.spring_xml_test;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
@SpringBootApplication
public class SpringXmlTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringXmlTestApplication.class, args);

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // 获取Bean实例 user是个单例
        val user = context.getBean("user", User.class);
        user.setId(123L);
        log.info("user {}", user);
        val user1 = context.getBean("user", User.class);
        log.info("user {}", user1);
    }

}
