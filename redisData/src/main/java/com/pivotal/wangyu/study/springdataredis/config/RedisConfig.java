package com.pivotal.wangyu.study.springdataredis.config;


import com.pivotal.wangyu.study.springdataredis.modle.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
@EnableRedisRepositories(basePackages = "com.pivotal.wangyu.study.springdataredis.repo")
public class RedisConfig {

    @Autowired
    RedisProperties redisProperties;


    @Bean
    RedisStandaloneConfiguration redisStandaloneConfiguration(){
        RedisStandaloneConfiguration myconfig =new RedisStandaloneConfiguration();
        myconfig.setHostName(redisProperties.getHost());
        myconfig.setPort(redisProperties.getPort());
        myconfig.setPassword(RedisPassword.of(redisProperties.getPassword()));
        return myconfig;
    }

    @Bean
    redis.clients.jedis.JedisPoolConfig jedisPoolConfig() {
        final redis.clients.jedis.JedisPoolConfig poolConfig = new redis.clients.jedis.JedisPoolConfig();
        poolConfig.setMaxTotal(128);
        poolConfig.setMaxIdle(128);
        poolConfig.setMinIdle(16);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        poolConfig.setTestWhileIdle(true);
        poolConfig.setMinEvictableIdleTimeMillis(Duration.ofSeconds(60).toMillis());
        poolConfig.setTimeBetweenEvictionRunsMillis(Duration.ofSeconds(30).toMillis());
        poolConfig.setNumTestsPerEvictionRun(3);
        poolConfig.setBlockWhenExhausted(true);
        return poolConfig;
    }

//    @Bean
//    LettuceConnectionFactory lettuceConnectionFactory() {
//        LettuceConnectionFactory lcf = new LettuceConnectionFactory(redisStandaloneConfiguration());
//        return lcf;
//    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory(redisStandaloneConfiguration());
    }


    @Bean
    public RedisTemplate<String, Project> redisTemplate() {
        RedisTemplate<String, Project> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setStringSerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new Jackson2JsonRedisSerializer(Project.class));
        return template;
    }
}
