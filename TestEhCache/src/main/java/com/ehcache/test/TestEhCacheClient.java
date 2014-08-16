package com.ehcache.test;

import java.util.List;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *

 * client start sleepclient finish sleepstart write time :1405366408714
   end write time :1405366408740
 * 
 * start get the object time :1405366410266
 * end get the object time :1405366410771
 * 
 * @author nelson
 */
public class TestEhCacheClient {

    private static final CacheManager cacheManager = CacheManager.create();
    private static final Logger logger = LoggerFactory.getLogger(TestEhCacheClient.class);

    public static void main(String[] args) {
        try {
            Cache cache = cacheManager.getCache("resourceCache");
            System.out.print("client start sleep");
            Thread.sleep(60 * 1000);
            System.out.print("client finish sleep");
            System.out.println("start write time :" + System.currentTimeMillis());
            for (int i = 0; i < 100; i++) {
                System.out.println("i=" + i);
                String value = "valuei" + i;
                Element element = new Element("key" + i, value);
                cache.put(element);
            }
            System.out.println("end write time :" + System.currentTimeMillis());

            // System.exit(1);
        } catch (Throwable t) {
            logger.error("error", t);
        }
    }

}
