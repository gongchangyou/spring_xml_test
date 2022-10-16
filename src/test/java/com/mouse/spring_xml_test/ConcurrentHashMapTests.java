package com.mouse.spring_xml_test;

import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

@Slf4j
@SpringBootTest
class ConcurrentHashMapTests {

    @Test
    void contextLoads() {
        ConcurrentHashMap<Integer, Integer> m = new ConcurrentHashMap<>();

        for (int i = 0; i < 1000;i++) {
            m.put(i, i);
        }

        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
            pool.submit(() -> {
//                m.entrySet().removeIf(entry -> entry.getKey() < 100);
//                m.entrySet().stream().filter((map) -> map.getValue().equals(3)).collect(Collectors.toList());
                for (Iterator<Map.Entry<Integer,Integer>> e = m.entrySet().iterator(); e.hasNext();) {
                    log.info("e = {} total={}" ,e.next(), m.size());
                    try {
                        e.remove();
                    } catch (Exception ex) {
                        log.error("ex ", ex);
                    }
                }
            });
        }

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
                    log.info("m total={}" , m.size());

    }

}
