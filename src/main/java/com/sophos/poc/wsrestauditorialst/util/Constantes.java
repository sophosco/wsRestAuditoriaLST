package com.sophos.poc.wsrestauditorialst.util;

import org.springframework.stereotype.Component;

@Component
public class Constantes {

	public final String STATUS_CODE_500 	= "500";
	public final String POC_ACTIVE_ENDPOINT = "POC_ACTIVE_ENDPOINT";
	public final String POC_ACTIVE_QUEUE 	= "POC_ACTIVE_QUEUE";
	public final String POC_ACTIVE_QUEUEERR	= "POC_ACTIVE_QUEUEERR";
	public final String POC_ACTIVE_USR		= "POC_ACTIVE_USR";
	public final String POC_ACTIVE_PSS		= "POC_ACTIVE_PSS";
	public final String POC_ACTIVE_CONCRR	= "POC_ACTIVE_CONCRR";
	public final String POC_REDIS_PASS		= "POC_REDIS_PASS";
	public final String POC_REDIS_PORT		= "POC_REDIS_PORT";
	public final String POC_REDIS_HOST		= "POC_REDIS_HOST";
	
	public final String PRP_FILE_ENDPOINT	= "active.default.endpoint";
	public final String PRP_FILE_QUEUE		= "active.default.queue";
	public final String PRP_FILE_QUEUEERR	= "active.default.error.queue";
	public final String PRP_FILE_USR		= "active.default.user";
	public final String PRP_FILE_PSS		= "active.default.pass";
	public final String PRP_FILE_CONCRR		= "active.default.concurrency";
	public final String PRP_REDIS_PASS		= "redis.default.pass";
	public final String PRP_REDIS_PORT		= "redis.default.port";
	public final String PRP_REDIS_HOST		= "redis.default.host";
	
}
