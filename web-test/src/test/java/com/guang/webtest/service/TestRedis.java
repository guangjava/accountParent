package com.guang.webtest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.Jedis;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:redis.xml"})
public class TestRedis {
	@Autowired
	private Jedis jedis;
	@Test
	public void testString(){
		jedis.set("name", "guang");
		System.out.println(jedis.get("name"));
		jedis.append("name", " is my name");
		System.out.println(jedis.get("name"));
		jedis.del("name");
		System.out.println(jedis.get("name"));
		jedis.mset("age","23","name","haha","qq","234234");
		jedis.incr("age");//+1
		System.out.println(jedis.get("age")+"-"+jedis.get("name")+jedis.get("qq"));
	}
	
	@Test
	public void testMap(){
		Map<String, String> map = new HashMap<>();
		map.put("name", "lala");
		map.put("age", "15");
		map.put("qq", "7745");
		jedis.hmset("user", map);
		List<String> list = jedis.hmget("user", "name","age","qq");
		System.out.println(list);
		jedis.hdel("user", "qq");
		Set<String> hkeys = jedis.hkeys("user");
		System.out.println(jedis.hlen("user"));
		System.out.println(jedis.exists("user"));
		for (String string : hkeys) {
			System.out.println(jedis.hget("user", string));
		}
	}
	
	@Test
	public void testList(){
		try {
			jedis.del("spring framework");
			//取出列表内容，第一个参数是key，第二个参数是起始位置，第三个参数是结束位置，-1表示显示所有
			//列表是一个队列结构
			System.out.println(jedis.lrange("spring framework", 0, -1));
			//向队头添加
			jedis.lpush("spring framework", "aop");
			jedis.lpush("spring framework", "ioc","test");
			System.out.println(jedis.lrange("spring framework", 0, -1));
			jedis.del("spring framework");
			jedis.rpush("spring framework", "aop");
			jedis.rpush("spring framework", "ioc","test");
			System.out.println(jedis.lrange("spring framework", 0, -1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSet(){
		jedis.del("user");
		jedis.sadd("user", "link","geok");//向set添加元素
		jedis.sadd("user", "detsa");
		jedis.sadd("user", "tomcat");
		jedis.sadd("user", "tomcat");
		System.out.println(jedis.smembers("user"));//返回set所有成员
		System.out.println(jedis.srandmember("user"));//随机返回set成员
		System.out.println(jedis.scard("user"));//返回set成员个数
		jedis.srem("user", "link");
		System.out.println(jedis.sismember("user", "fae"));
		System.out.println(jedis.scard("user"));
	}
	
	@Test
	public void testSort(){
		jedis.lpush("array", "8","4","6","2");
		System.out.println(jedis.lrange("array", 0, -1));
		List<String> sort = jedis.sort("array");
		System.out.println(sort);
		System.out.println(jedis.lrange("array", 0, -1));
	}
}
