package com.mouse.spring_xml_test;

/**
 * @author gongchangyou
 * @version 1.0
 * @date 2022/7/25 16:21
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class Student implements Person {

    @Autowired
    Face face;

    private Long id = 3L;
    private String name;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public synchronized void waitTest() {
        try {
            wait(100L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
