package com.obnay.blocks;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void listTest() {
        List<String> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        result.addAll(temp);
        System.out.println(result);

        temp.add("1");
        result.addAll(temp);
        System.out.println(result);

        result.add("2");
        System.out.println(result);
        System.out.println(result.size());
    }
}
