package com.mouse.spring_xml_test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootTest
class BeanUtilTests {

    @Test
    void contextLoads() {
        User user = new User();
        User user2 = new User();
        StopWatch st = new StopWatch();
        st.start("spring BeanUtils");
        for (int i = 0; i <=1000;i++) {
            BeanUtils.copyProperties(user, user2);
        }
        st.stop();

        st.start("apache BeanUtils");
        for (int i = 0; i <=1000;i++) {
            try {
                org.apache.commons.beanutils.BeanUtils.copyProperties(user, user2);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        st.stop();

        log.info("time= {}", st.prettyPrint());

    }

}
