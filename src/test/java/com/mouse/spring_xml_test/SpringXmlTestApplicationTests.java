package com.mouse.spring_xml_test;

import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.util.HashMap;

@Slf4j
@SpringBootTest
class SpringXmlTestApplicationTests {

    @Test
    void contextLoads() {
        val map = new HashMap<Integer, String>();
        val cache = Caffeine.newBuilder()
                .initialCapacity(1000000)
                .maximumSize(1000000)//100w个小区
                .recordStats()
                .build();
        for (int i = 0; i < 1000000; i ++) {
            map.put(i, String.valueOf(i));
            cache.put(i, String.valueOf(i));
        }

        val sw = new StopWatch();
        sw.start("steam");
        for (int j=0;j<10;j++) {
            map.values().stream().filter(i -> i.equals("949234")).findFirst();
        }
        sw.stop();

        sw.start("parallel");
        for (int j=0;j<10;j++) {
            map.values().stream().parallel().filter(i -> i.equals("949234")).findFirst();
        }
        sw.stop();



        sw.start("wait");

        val s = new Student();
        try {
            s.waitTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
        sw.stop();



        sw.start("localcache");
        for (int j=0;j<10;j++) {
            cache.asMap().values().stream().filter(i -> i.equals("949234")).findFirst();
        }
        sw.stop();

        log.info("a= cost={}",sw.prettyPrint());


    }

}
