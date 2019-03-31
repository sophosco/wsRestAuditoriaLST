package com.sophos.poc.wsrestauditorialst.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sophos.poc.wsrestauditorialst.cache.repository.AccionRepository;
import com.sophos.poc.wsrestauditorialst.model.Accion;

@Service
public class ActiveMQtoRadisService {

	@Autowired
	private AccionRepository redisRepository;
	
	private static final Logger logger = LogManager.getLogger( ActiveMQtoRadisService.class);
	
	public void putMessage(String rq) throws Exception {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Accion action = mapper.readValue(rq, Accion.class);
			redisRepository.save(action);	
			logger.info("Mensaje Enviado a Redis");
		}catch (Exception e) {
			logger.error("ERROR redisRepository info: ", redisRepository.toString());
			throw e;
		}		
	}
}
