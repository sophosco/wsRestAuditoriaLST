package com.sophos.poc.wsrestauditorialst.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.ErrorHandler;


@Service
public class ActiveMqPoCListenerErrorHandler implements ErrorHandler  {

	private static final Logger logger = LogManager.getLogger(ActiveMqPoCListenerErrorHandler.class);
	@Override
	public void handleError(Throwable t) {
		logger.error("Error capturado en la clase AWSActiveMqListenerErrorHandler", t);		
	}

}
