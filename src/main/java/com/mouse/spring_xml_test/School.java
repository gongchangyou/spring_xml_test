package com.mouse.spring_xml_test;

import lombok.Data;
import org.springframework.beans.factory.BeanNameAware;

/**
 * @author gongchangyou
 * @version 1.0
 * @date 2022/9/15 13:53
 */
@Data
public class School implements BeanNameAware {
    private User user;

    @Override
    public void setBeanName(String s) {

    }

    public void setName(String name) {
        this.user.setName(name);
    }
}
