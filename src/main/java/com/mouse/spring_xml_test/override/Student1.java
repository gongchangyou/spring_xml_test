package com.mouse.spring_xml_test.override;

/**
 * @author gongchangyou
 * @version 1.0
 * @date 2022/7/25 16:21
 */

import com.mouse.spring_xml_test.Face;
import com.mouse.spring_xml_test.Person;
import com.mouse.spring_xml_test.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("stu1")
@Order(2)
public class Student1 extends Student {

    @Autowired
    Face face;

    private Long id = 4L;
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
