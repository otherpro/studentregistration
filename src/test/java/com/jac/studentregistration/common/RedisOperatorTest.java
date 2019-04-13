package com.jac.studentregistration.common;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * RedisOperator Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Apr 2, 2019</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisOperatorTest {
    @Autowired
    private RedisOperator redis;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: ttl(String key)
     */
    @Test
    public void testTtl() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: expire(String key, long timeout)
     */
    @Test
    public void testExpire() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: incr(String key, long delta)
     */
    @Test
    public void testIncr() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: keys(String pattern)
     */
    @Test
    public void testKeys() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: del(String key)
     */
    @Test
    public void testDel() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: set(String key, String value)
     */
    @Test
    public void testSetForKeyValue() throws Exception {
        String code = "testcode";
        System.out.println("wxlogin - code: " + code);



        // 存入session到redis
        redis.set("user-redis-session:",
                "code",
                1000 * 60 * 30);

    }

    /**
     * Method: set(String key, String value, long timeout)
     */
    @Test
    public void testSetForKeyValueTimeout() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: get(String key)
     */
    @Test
    public void testGet() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: hset(String key, String field, Object value)
     */
    @Test
    public void testHset() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: hget(String key, String field)
     */
    @Test
    public void testHget() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: hdel(String key, Object... fields)
     */
    @Test
    public void testHdel() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: hgetall(String key)
     */
    @Test
    public void testHgetall() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: lpush(String key, String value)
     */
    @Test
    public void testLpush() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: lpop(String key)
     */
    @Test
    public void testLpop() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: rpush(String key, String value)
     */
    @Test
    public void testRpush() throws Exception {
//TODO: Test goes here... 
    }


} 
