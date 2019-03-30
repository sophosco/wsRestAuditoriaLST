package com.sophos.poc.wsrestauditorialst.listener;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.destination.DestinationResolver;
import org.springframework.jms.support.destination.DynamicDestinationResolver;

import com.sophos.poc.wsrestauditorialst.util.DefaultProperties;



@Configuration
@EnableJms
public class ActiveMQPoCConnectionFactory {

	@Autowired
	private DefaultProperties conf;
	@Autowired
	private ActiveMqPoCListenerErrorHandler errorHadler;
	
	private static final Logger logger = LogManager.getLogger(ActiveMQPoCConnectionFactory.class);
	
	@Bean
	public ConnectionFactory connectionFactory() throws JMSException {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(conf.getEndpoint());
		connectionFactory.setUserName(conf.getUser());
		connectionFactory.setPassword(conf.getPass());
		return connectionFactory;

	}

	@Bean
	public JmsListenerContainerFactory<?> jmsListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		try {
			factory.setConnectionFactory(connectionFactory());
			// core poll size threads and max poll size Example '4-8'
			factory.setConcurrency(conf.getConcurrency());
			factory.setErrorHandler(errorHadler);
			factory.setDestinationResolver(myDestinationResolver());
			return factory;
		} catch (JMSException e) {
			logger.error("Error JmsListenerContainerFactory",e);
			return null;
		}
	}
	
	@Bean
	public DestinationResolver myDestinationResolver() {
		return new DestinationResolver() {
			private DestinationResolver dynamicDestinationResolver = new DynamicDestinationResolver();
			@Override
			public Destination resolveDestinationName(Session session, String destinationName, boolean pubSubDomain)
					throws JMSException {
				String dname = conf.getQueue();
				return dynamicDestinationResolver.resolveDestinationName(session, dname, pubSubDomain);
			}
		};
	}
}
