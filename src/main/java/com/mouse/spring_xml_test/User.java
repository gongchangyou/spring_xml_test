package com.mouse.spring_xml_test;

import lombok.Data;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author gongchangyou
 * @version 1.0
 * @date 2022/7/25 16:21
 */
//@Component 这里不能再注册了，会报错，
@Order(1)
@Data
public class User implements Person {

    private Face face;
    private Long id = 40L;
    private String name;
    private Map<String, String> dreams;

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
}
