package com.sophos.poc.wsrestauditorialst.service;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sophos.poc.wsrestauditorialst.util.DefaultProperties;


@Service
public class ActiveMQtoActiveMQService {
	
	private static final Logger logger = LogManager.getLogger(ActiveMQtoActiveMQService.class);

	@Autowired
	private DefaultProperties dfp;
	
	public boolean publishMessage(String request) {
		try {
			String message = request;

			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(dfp.getEndpoint());
			connectionFactory.setUserName(dfp.getUser());
			connectionFactory.setPassword(dfp.getPass());
			PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory();
			pooledConnectionFactory.setConnectionFactory(connectionFactory);
			pooledConnectionFactory.setMaxConnections(10);
			Connection producerConnection = pooledConnectionFactory.createConnection();

			producerConnection.start();
			Session producerSession = producerConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination producerDestination = producerSession.createQueue(dfp.getQueue());
			MessageProducer producer = producerSession.createProducer(producerDestination);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			producer.setTimeToLive(20000l);

			TextMessage producerMessage = producerSession.createTextMessage(message);
			producer.send(producerMessage);
			try {
				producer.close();
				producerSession.close();
				producerConnection.close();
				pooledConnectionFactory.stop();
			} catch (Exception e) {
				logger.error("Close Exception", e);
			}
			return true;
		} catch (JMSException jmsex) {			
			logger.error("Error Enviando Mensaje a ActiveMQ jmsex", jmsex);
			return false;
		} catch (Exception ex) {
			logger.error("Error Enviando Mensaje a ActiveMQ ex", ex);
			return false;
		}
	}
	
	public boolean publishMessage(String request, String queue) {
		try {
			String message = request;

			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(dfp.getEndpoint());
			connectionFactory.setUserName(dfp.getUser());
			connectionFactory.setPassword(dfp.getPass());
			PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory();
			pooledConnectionFactory.setConnectionFactory(connectionFactory);
			pooledConnectionFactory.setMaxConnections(10);
			Connection producerConnection = pooledConnectionFactory.createConnection();

			producerConnection.start();
			Session producerSession = producerConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination producerDestination = producerSession.createQueue(queue);
			MessageProducer producer = producerSession.createProducer(producerDestination);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			producer.setTimeToLive(20000l);

			TextMessage producerMessage = producerSession.createTextMessage(message);
			producer.send(producerMessage);
			try {
				producer.close();
				producerSession.close();
				producerConnection.close();
				pooledConnectionFactory.stop();
			} catch (Exception e) {
				logger.error("Close Exception", e);				
			}
			return true;
		} catch (JMSException jmsex) {			
			logger.error("Error Enviando Mensaje a ActiveMQ jmsex", jmsex);
			return false;
		} catch (Exception ex) {
			logger.error("Error Enviando Mensaje a ActiveMQ ex", ex);
			return false;
		}
	}
}
