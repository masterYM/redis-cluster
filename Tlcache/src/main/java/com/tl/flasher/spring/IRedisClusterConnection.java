package com.tl.flasher.spring;

import com.tl.flasher.jedis.JedisCluster;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public interface IRedisClusterConnection extends InitializingBean, DisposableBean {
	
	JedisCluster getJedisCluster();
	
	String getBusiness();

}
