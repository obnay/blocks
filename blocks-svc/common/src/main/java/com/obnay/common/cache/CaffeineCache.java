package com.obnay.common.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;

/**
 * CaffeineCache
 *
 * @author taoyanbo
 * @date 2020-03-26 23:05
 */
public class CaffeineCache {

    private Cache<String, String> cache;

    private CaffeineCache() {
        cache = Caffeine.newBuilder().expireAfterAccess(1, TimeUnit.HOURS).maximumSize(10_1000).build();
    }

    private static class CaffeineCacheInstance {
        private static final CaffeineCache instance = new CaffeineCache();
    }

    public static CaffeineCache getInstance() {
        return CaffeineCacheInstance.instance;
    }

    public Cache<String, String> getCache() {
        return cache;
    }

}


