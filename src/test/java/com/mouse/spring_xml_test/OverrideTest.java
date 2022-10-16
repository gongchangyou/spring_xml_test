package com.mouse.spring_xml_test;

import com.mouse.spring_xml_test.override.B;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author gongchangyou
 * @version 1.0
 * @date 2022/8/18 20:39
 */
@Slf4j
@SpringBootTest
public class OverrideTest {
    @Autowired
    private com.mouse.spring_xml_test.override.B b;
    @Test
    void contextLoads() {
        log.info("b" , b);

    }
}
