package com.lg.movies;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lg.movies.utils.RedisClient;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=LiuMoviesApplication.class)
public class RedisTest {

	@Autowired
	private RedisClient redisClient;
	
	@Test
	public void testRedis(){
		String result = redisClient.getStr("users");
		if (result==null||result.trim().equals("")) {
			result="[{\"id\":1,\"name\":\"张三\",\"addr\":\"广东珠海\",\"age\":13},{\"id\":2,\"name\":\"李四\",\"addr\":\"广东广州\",\"age\":14}]";
			redisClient.set("users", result);
			System.out.println("redis 设置数据:"+result);
		}else{
			System.out.println("redis 获取到的:"+result);
		}
	}
	
	
	@Test
	public void getExpire() {
		System.out.println(redisClient.getExpire("users"));
	}
	
	@Test
	public void delete() {
		redisClient.del("users");
	}
}