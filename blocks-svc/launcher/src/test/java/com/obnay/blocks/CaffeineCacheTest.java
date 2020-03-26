package com.obnay.blocks;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author taoyanbo
 * @date 2020-03-26 23:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CaffeineCacheTest {

    @Test
    public void cacheTest() {
        Cache<String, Object> cache = Caffeine.newBuilder().maximumSize(10_1000).build();

        String key = "name";
        System.out.println(cache.getIfPresent(key));

        cache.get(key, s -> "Springboot");

        System.out.println(cache.getIfPresent(key));

    }
}
