package com.mouse.spring_xml_test;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gongchangyou
 * @version 1.0
 * @date 2022/7/29 14:19
 */
@RequestMapping("test")
@RestController
@Slf4j
public class TestRequest {
    @Autowired
    List<Person> userList;

    @RequestMapping("hi")
    String hi() {
        log.info("user {}", userList);
        return "hi";
    }
}
