package com.mouse.spring_xml_test;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author gongchangyou
 * @version 1.0
 * @date 2022/8/9 15:16
 */
@Slf4j
@SpringBootTest
public class MapTest {
    @Test
    void contextLoads() {
        ConcurrentHashMap<Integer, AtomicInteger> m = new ConcurrentHashMap<>();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10), new ThreadPoolExecutor.CallerRunsPolicy());
        m.putIfAbsent(1, new AtomicInteger(1));
        for (int i = 0; i < 1000; i++) {
            pool.submit(() -> {
                log.info("before m={}", m);
                m.get(1).addAndGet(1);

                log.info("m={}", m);
            });
        }
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("m={}", m);

    }
}
