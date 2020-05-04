package com.cun.redis;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisReactiveAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableAutoConfiguration(exclude = {RedisAutoConfiguration.class, RedisReactiveAutoConfiguration.class}) // 注意
public class RedisConfig {

    @Bean("userTokenRedisConnection")
    public LettuceConnectionFactory userTokenRedisConnection() {
        RedisStandaloneConfiguration server = new RedisStandaloneConfiguration();
        server.setHostName("120.10.10.130");
        server.setDatabase(10);
        server.setPort(6378);
        return new LettuceConnectionFactory(server);
    }

    @Bean("adminTokenRedisConnection")
    public LettuceConnectionFactory adminTokenRedisConnection() {
        RedisStandaloneConfiguration server = new RedisStandaloneConfiguration();
        server.setHostName("120.10.10.130");
        server.setDatabase(11);
        server.setPort(6378);
        return new LettuceConnectionFactory(server);
    }

    @Bean("adminTokenRedisTemplate")
    public RedisTemplate<String, String> adminTokenRedisTemplate() {
        RedisTemplate<String, String> template = new RedisTemplate<String, String>(); //只能对字符串的键值操作
        template.setConnectionFactory(adminTokenRedisConnection());
        return template;
    }

    @Bean("userTokenRedisTemplate")
    public RedisTemplate<String, String> userTokenRedisTemplate() {
        RedisTemplate<String, String> template = new RedisTemplate<String, String>(); //只能对字符串的键值操作
        template.setConnectionFactory(userTokenRedisConnection());
        return template;
    }

    @Bean("redisTemplate")
    public RedisTemplate<String, String> redisTemplate() {
        RedisTemplate<String, String> template = new RedisTemplate<String, String>(); //只能对字符串的键值操作
        template.setConnectionFactory(userTokenRedisConnection());
        return template;
    }
}
