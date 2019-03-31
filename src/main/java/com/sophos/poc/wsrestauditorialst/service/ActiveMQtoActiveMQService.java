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
		Connection producerConnection = null;
		Session producerSession = null;
		MessageProducer producer = null;
		PooledConnectionFactory pooledConnectionFactory = null;
		try {
			String message = request;

			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(dfp.getEndpoint());
			connectionFactory.setUserName(dfp.getUser());
			connectionFactory.setPassword(dfp.getPass());
			pooledConnectionFactory = new PooledConnectionFactory();
			pooledConnectionFactory.setConnectionFactory(connectionFactory);
			pooledConnectionFactory.setMaxConnections(10);
			producerConnection = pooledConnectionFactory.createConnection();
			
			producerConnection.start();
			producerSession = producerConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination producerDestination = producerSession.createQueue(dfp.getQueue());
			producer = producerSession.createProducer(producerDestination);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			producer.setTimeToLive(20000l);

			TextMessage producerMessage = producerSession.createTextMessage(message);
			producer.send(producerMessage);
			return true;
		} catch (JMSException jmsex) {			
			logger.error("Error Enviando Mensaje a ActiveMQ jmsex", jmsex);
			return false;
		} catch (Exception ex) {
			logger.error("Error Enviando Mensaje a ActiveMQ ex", ex);
			return false;
		}finally {
			if(producer!= null) {try {producer.close();}catch(Exception e) {logger.error("Error Closing producer: ", e);}}
			if(pooledConnectionFactory != null) {try {pooledConnectionFactory.stop();} catch (Exception e) {logger.error("Error Stopping pooledConnectionFactory: ", e);}}		
			if(producerSession!= null) { try {producerSession.close();} catch (Exception e) {logger.error("Error Closing  producerSession: ", e);}}
			if(producerConnection != null) {try {producerConnection.close();} catch (Exception e) {logger.error("Error Closing producerConnection: ", e);}}				

		}
	}
	
	public boolean publishMessage(String request, String queue) {
		Connection producerConnection = null;
		Session producerSession = null;
		MessageProducer producer = null;
		PooledConnectionFactory pooledConnectionFactory = null;
		try {
			String message = request;

			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(dfp.getEndpoint());
			connectionFactory.setUserName(dfp.getUser());
			connectionFactory.setPassword(dfp.getPass());
			pooledConnectionFactory = new PooledConnectionFactory();
			pooledConnectionFactory.setConnectionFactory(connectionFactory);
			pooledConnectionFactory.setMaxConnections(10);
			producerConnection = pooledConnectionFactory.createConnection();

			producerConnection.start();
			producerSession = producerConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination producerDestination = producerSession.createQueue(queue);
			producer = producerSession.createProducer(producerDestination);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			producer.setTimeToLive(20000l);

			TextMessage producerMessage = producerSession.createTextMessage(message);
			producer.send(producerMessage);
			return true;
		} catch (JMSException jmsex) {			
			logger.error("Error Enviando Mensaje a ActiveMQ jmsex", jmsex);
			return false;
		} catch (Exception ex) {
			logger.error("Error Enviando Mensaje a ActiveMQ ex", ex);
			return false;
		}finally {
			if(producer!= null) {try {producer.close();}catch(Exception e) {logger.error("Error Closing producer: ", e);}}
			if(pooledConnectionFactory != null) {try {pooledConnectionFactory.stop();} catch (Exception e) {logger.error("Error Stopping pooledConnectionFactory: ", e);}}		
			if(producerSession!= null) { try {producerSession.close();} catch (Exception e) {logger.error("Error Closing  producerSession: ", e);}}
			if(producerConnection != null) {try {producerConnection.close();} catch (Exception e) {logger.error("Error Closing producerConnection: ", e);}}				

		}
	}
}
