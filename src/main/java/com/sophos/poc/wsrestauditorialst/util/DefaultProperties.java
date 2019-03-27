package com.sophos.poc.wsrestauditorialst.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.context.annotation.Configuration;


@Configuration
public class DefaultProperties {
	
	public  String queue;
	public  String errorQueue;
	private String endpoint;
	private String user;
	private String pass;
	private String concurrency;
	
	private static String file = "config.properties"; 
	private static DefaultProperties instance = null;
	
	public DefaultProperties getInstance() {
		if (instance == null) {
			return instance = new DefaultProperties();
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
			
			setEndpoint(envEP != null && envEP != "" ? envEP : pr.getProperty(cts.PRP_FILE_ENDPOINT));
			setQueue(envQU != null && envQU != "" ? envQU : pr.getProperty(cts.PRP_FILE_QUEUE));
			setUser(envUS != null && envUS != "" ? envUS : pr.getProperty(cts.PRP_FILE_USR));
			setPass(envPS != null && envPS != "" ? envPS : pr.getProperty(cts.PRP_FILE_PSS));
			setErrorQueue(envQE != null && envQE!= "" ? envQE : pr.getProperty("active.default.error.queue"));
			setConcurrency(envCC != null && envCC != "" ? envCC : pr.getProperty("active.default.concurrency"));
			
		} catch (IOException ex) {
			System.out.println("Problem occurs when reading Default Config Properties config.properties !!!");
			ex.printStackTrace();
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
}
