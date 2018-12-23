package com.duli.rediscluster;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class RedisCluster {
    public static void main(String[] args) throws IOException {
        Set<HostAndPort> jedisClusterNode = new HashSet<>();
        jedisClusterNode.add(new HostAndPort("192.168.137.60", 8001));
        jedisClusterNode.add(new HostAndPort("192.168.137.62", 8002));
        jedisClusterNode.add(new HostAndPort("192.168.137.61", 8003));
        jedisClusterNode.add(new HostAndPort("192.168.137.60", 8004));
        jedisClusterNode.add(new HostAndPort("192.168.137.62", 8005));
        jedisClusterNode.add(new HostAndPort("192.168.137.61", 8006));

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(100);
        config.setMaxIdle(10);
        config.setTestOnBorrow(true);
        //connectionTimeout：指的是连接一个url的连接等待时间
        //soTimeout：指的是连接上一个url，获取response的返回等待时间
        JedisCluster jedisCluster = new JedisCluster(jedisClusterNode,
                6000, 5000, 10, "duli", config);
        System.out.println(jedisCluster.set("name", "duli"));
        System.out.println(jedisCluster.set("age", "18"));

        System.out.println(jedisCluster.get("name"));
        System.out.println(jedisCluster.get("age"));

        jedisCluster.close();
    }
}



