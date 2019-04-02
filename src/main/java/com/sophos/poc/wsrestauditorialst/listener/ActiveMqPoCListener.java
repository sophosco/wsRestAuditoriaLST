package com.sophos.poc.wsrestauditorialst.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.sophos.poc.wsrestauditorialst.service.ActiveMQtoActiveMQService;
import com.sophos.poc.wsrestauditorialst.service.ActiveMQtoRadisService;
import com.sophos.poc.wsrestauditorialst.util.DefaultProperties;

@Component
public class ActiveMqPoCListener {

	@Autowired
	private DefaultProperties conf;
	@Autowired
	private ActiveMQtoRadisService toRadis;
	@Autowired
	private ActiveMQtoActiveMQService toActive;
	
	private static final Logger logger = LogManager.getLogger(ActiveMqPoCListener.class);
	
	@JmsListener(destination = "poc.audit.queue")
	public void receiveMessage(String rq) {
		try {
			toRadis.putMessage(rq);
			toActive.publishMessage(rq, conf.getAuditQueue(), true);
		}catch(Exception ex) {
			logger.error("Se presento un error enviando mensaje a Redis, Se retornara el mensaje a ActiveMQ:" + ex);
			toActive.publishMessage(rq, conf.getErrorQueue(), false);
		}
	}
}
