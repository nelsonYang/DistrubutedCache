package com.ehcache.test;

import java.util.List;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author nelson
 */
public class TestEhCache {

    private static final CacheManager cacheManager = CacheManager.create();
    private static final Logger logger = LoggerFactory.getLogger(TestEhCache.class);

    public static void main(String[] args) {
        try {
            Cache cache = cacheManager.getCache("resourceCache");
            System.out.println("server start sleep");
            Thread.sleep(60 * 1000l);
            System.out.println("server finished sleep");
            while (true) {
                List<String> keys = cache.getKeys();
                System.out.println("keys.size=" + keys.size());
                if (!keys.isEmpty()) {
                    System.out.println("start get the object time :" + System.currentTimeMillis());
                    for (String key : keys) {
                        System.out.println(cache.get(key));
                    }
                    System.out.println("end get the object time :" + System.currentTimeMillis());
                    break;
                }
            }
            System.out.println("finish");
            // System.exit(1);
        } catch (Throwable t) {
            logger.error("error", t);
        }
    }

}
