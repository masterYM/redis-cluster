package com.tl.flasher.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import redis.clients.jedis.Jedis;

public interface IRedisConnection extends InitializingBean, DisposableBean {
    Jedis getJedis();

    String getBusiness();
}
