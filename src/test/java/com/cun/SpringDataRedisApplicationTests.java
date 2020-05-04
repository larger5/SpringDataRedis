package com.cun;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * 官方文档：https://docs.spring.io/spring-data/redis/docs/2.2.7.RELEASE/reference/html/#reference
 */
@SpringBootTest
class SpringDataRedisApplicationTests {

    @Resource(name = "userTokenRedisTemplate")
    private RedisTemplate<String, String> userTokenRedisTemplate;

    @Resource(name = "adminTokenRedisTemplate")
    private RedisTemplate<String, String> adminTokenRedisTemplate;

    @Test
    void contextLoads() {

        /* 用户token */
        userTokenRedisTemplate.opsForValue().set("0243358fed674c79ce249d88e4334926", "userId_10001");
        userTokenRedisTemplate.opsForValue().set("0737a9b95a501f5464b3835cf5d7dacb", "userId_10002");

        /* 管理员token */
        adminTokenRedisTemplate.opsForValue().set("12b217cf6724474b1a781616fb021365", "adminId_10001");
        adminTokenRedisTemplate.opsForValue().set("1fdf7deac423c77efcf72aea196ad300", "adminId_10002");
        adminTokenRedisTemplate.opsForValue().set("2ba307112b47562c9ae6fe8dc1b70668", "adminId_10003");

    }

}
