package com.sophos.poc.wsrestauditorialst.cache;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
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
		return new JedisConnectionFactory();
	}
	 
	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
	    RedisTemplate<String, Object> template = new RedisTemplate<>();
	    template.setConnectionFactory(jedisConnectionFactory());
	    logger.info("JedisConnectionFactory INFO: HostName-", jedisConnectionFactory().getHostName() );
	    logger.info("JedisConnectionFactory INFO: Port-", jedisConnectionFactory().getPort() );
	    return template;
	}

}
