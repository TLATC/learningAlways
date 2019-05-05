package com.shawn.learningalways;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 *　　　　　　　 ┏┓　 ┏┓+ +
 *　　　　　　　┏┛┻━━━┛┻┓ + +
 *　　　　　　　┃　　　　　　┃ 　
 *　　　　　　　┃　　　━　　 ┃ ++ + + +
 *　　　　　　 ████━████  ┃+
 *　　　　　　　┃　　　　　　　┃ +
 *　　　　　　　┃　　　┻　　　┃
 *　　　　　　　┃　　　　　　┃ + +
 *　　　　　　　┗━┓　　　┏━┛
 *　　　　　　　　 ┃　　　┃　　　　　　　　　　　
 *　　　　　　　　 ┃　　　┃ + + + +
 *　　　　　　　　 ┃　　　┃　　　　Code is far away from bug with the animal protecting　　　　　　　
 *　　　　　　　　 ┃　　　┃ + 　　　　神兽保佑,代码无bug　　
 *　　　　　　　　 ┃　　　┃
 *　　　　　　　　 ┃　　　┃　　+　　　　　　　　　
 *　　　　　　　　 ┃　 　 ┗━━━┓ + +
 *　　　　　　　　 ┃ 　　　　   ┣┓
 *　　　　　　　　 ┃ 　　　　　 ┏┛
 *　　　　　　　　 ┗┓┓┏━┳┓┏┛ + + + +
 *　　　　　　　　  ┃┫┫ ┃┫┫
 *　　　　　　　　  ┗┻┛ ┗┻┛+ + + +
 *
 *
 *
 * @ClassName: HsipccwebApplication
 * @Description springboot入口类
 * @author: Shawn Wu
 * @date: 2019/3/21 22:18
 * @version:
 */
@SpringBootApplication
@EnableScheduling //开启定时任务
@EnableAsync //开启异步任务
@MapperScan("com.shawn.learningalways.*.dao") //mybatis接口扫描
public class LearningAlwaysApplication {

	/**
	 * @Description 设置redisTemplate的序列化策略：
	 *              key值使用String序列化方式，value还是采用默认的JDK序列化
	 * @param redisConnectionFactory
	 * @return
	 * @date 2019/3/21 22:21
	 * @auther Shawn Wu
	 */
	@Bean
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		// 创建redisTemplate模板
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
		// 关联redisConnectionFactory
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		// key值使用String序列化方式，value还是采用默认的JDK序列化
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}


	public static void main(String[] args) {
		SpringApplication.run(LearningAlwaysApplication.class, args);
	}
}
