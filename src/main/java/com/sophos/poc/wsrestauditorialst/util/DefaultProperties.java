package com.sophos.poc.wsrestauditorialst.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultProperties {
	
	private String queue;
	private String errorQueue;
	private String endpoint;
	private String user;
	private String pass;
	private String concurrency;
	private String redisHost;
	private int	   redisPort;
	private String redisPass;
	
	private static final Logger logger = LogManager.getLogger(DefaultProperties.class);
	
	
	private static String file = "config.properties"; 
	private static DefaultProperties instance = null;
	
	public DefaultProperties getInstance() {
		if (instance == null) {
			return new DefaultProperties();
		}
		return instance;
	}
	public DefaultProperties() {
		Properties pr = new Properties();
		try {	
			Constantes cts = new Constantes();
			InputStream inputStream = DefaultProperties.class.getClassLoader().getResourceAsStream(file); 
			pr.load(inputStream);
			String envEP = System.getenv().get(cts.POC_ACTIVE_ENDPOINT);
			String envQU = System.getenv().get(cts.POC_ACTIVE_QUEUE);
			String envUS = System.getenv().get(cts.POC_ACTIVE_USR);
			String envPS = System.getenv().get(cts.POC_ACTIVE_PSS);
			String envQE = System.getenv().get(cts.POC_ACTIVE_QUEUEERR);
			String envCC = System.getenv().get(cts.POC_ACTIVE_CONCRR);
			String envRP = System.getenv().get(cts.POC_REDIS_PORT);
			String envRH = System.getenv().get(cts.POC_REDIS_HOST);
			String envRC = System.getenv().get(cts.POC_REDIS_PASS);
			
			setEndpoint(envEP != null && !envEP.equals("") ? envEP : pr.getProperty(cts.PRP_FILE_ENDPOINT));
			setQueue(envQU != null && !envQU.equals("") ? envQU : pr.getProperty(cts.PRP_FILE_QUEUE));
			setUser(envUS != null && !envUS.equals("") ? envUS : pr.getProperty(cts.PRP_FILE_USR));
			setPass(envPS != null && !envPS.equals("") ? envPS : pr.getProperty(cts.PRP_FILE_PSS));
			setErrorQueue(envQE != null && !envQE.equals("") ? envQE : pr.getProperty(cts.PRP_FILE_QUEUEERR));
			setConcurrency(envCC != null && !envCC.equals("") ? envCC : pr.getProperty(cts.PRP_FILE_CONCRR));
			setRedisHost(envRH != null && !envRH.equals("") ? envRH : pr.getProperty(cts.PRP_REDIS_HOST));
			setRedisPass(envRC != null && !envRC.equals("") ? envRC : pr.getProperty(cts.PRP_REDIS_PASS));
			setRedisPort(envRP != null && !envRP.equals("") ? Integer.parseInt(envRP) : Integer.parseInt(pr.getProperty(cts.PRP_REDIS_PORT)) );
			
		} catch (IOException ex) {
			logger.error("Problem occurs when reading Default Config Properties config.properties !!!", ex);
		} catch (NumberFormatException ex) {
			setRedisPort(6379);
		}
		
	}
	public String getQueue() {
		return queue;
	}
	public void setQueue(String queue) {
		this.queue = queue;
	}
	
	public String getErrorQueue() {
		return errorQueue;
	}
	public void setErrorQueue(String errorQueue) {
		this.errorQueue = errorQueue;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getConcurrency() {
		return concurrency;
	}
	public void setConcurrency(String concurrency) {
		this.concurrency = concurrency;
	}
	public String getRedisHost() {
		return redisHost;
	}
	public void setRedisHost(String redisHost) {
		this.redisHost = redisHost;
	}
	public int getRedisPort() {
		return redisPort;
	}
	public void setRedisPort(int redisPort) {
		this.redisPort = redisPort;
	}
	public String getRedisPass() {
		return redisPass;
	}
	public void setRedisPass(String redisPass) {
		this.redisPass = redisPass;
	}
}
