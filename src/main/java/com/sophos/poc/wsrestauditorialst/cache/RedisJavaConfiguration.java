package com.sophos.poc.wsrestauditorialst.cache;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;


@Configuration
@ComponentScan("com.sophos.poc.wsrestauditorialst.cache")
@EnableRedisRepositories(basePackages = "com.sophos.poc.wsrestauditorialst.cache.repository")
@PropertySource("classpath:application.properties")
public class RedisJavaConfiguration {
	
	private static final Logger logger = LogManager.getLogger(RedisJavaConfiguration.class);
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
	    RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration("redis-master", 6379);
	    return new JedisConnectionFactory(redisStandaloneConfiguration);
	}
	 
	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
	    RedisTemplate<String, Object> template = new RedisTemplate<>();
	    template.setConnectionFactory(jedisConnectionFactory());
	    logger.info("HOST Redis: 172.20.88.24" );
	    return template;
	}

}
