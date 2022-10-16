package com.mouse.spring_xml_test.override;

import com.mouse.spring_xml_test.Person;
import com.mouse.spring_xml_test.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author gongchangyou
 * @version 1.0
 * @date 2022/8/18 20:38
 */
@Component
public class B extends A {
    @Autowired
    @Qualifier(value = "stu1")
    private Student student;

    public B(Student student) {
       super.student = student;
    }

}
