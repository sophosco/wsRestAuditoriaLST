package com.sophos.poc.wsrestauditorialst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sophos.poc.wsrestauditorialst.cache.repository.AccionRepository;
import com.sophos.poc.wsrestauditorialst.model.Accion;

@Service
public class ActiveMQtoRadisService {

	@Autowired
	private AccionRepository redisRepository;
	
	public void putMessage(String rq) throws Exception {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Accion action = mapper.readValue(rq, Accion.class);
			redisRepository.save(action);	
		}catch (Exception e) {
			throw e;
		}		
	}
}
