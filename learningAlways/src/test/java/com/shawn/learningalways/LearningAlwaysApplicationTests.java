package com.shawn.learningalways;

import com.shawn.learningalways.example.controller.HelloController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearningAlwaysApplicationTests {

	/**
	 * MockMvc实现了对Http请求的模拟，但不依赖于网络环境
	 */
	private MockMvc mvc;

	/**
	 * MockMvc初始化方法
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception{
		// 通过MockMvcBuilder构造MockMvc的构造器
		mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
	}

	/**
	 * @Description 模拟http请求，测试HelloController中的hello方法
	 * @param
	 * @return
	 * @date 2019/4/8 21:14
	 * @author Shawn Wu
	 */
	@Test
	public void getHello() throws Exception{
		/*
		 * 调用perform，执行一个RequestBuilder请求，调用controller的业务处理逻辑
		 */
		// 模拟get请求，访问/hello
		mvc.perform(MockMvcRequestBuilders.get("/helloWorld").accept(MediaType.APPLICATION_JSON))
				// 请求完成后的断言，使用StatusResultMatchers对请求结果进行验证
				.andExpect(status().isOk())
				// 使用ContentResultMatchers对请求返回的内容进行验证
				.andExpect(content().string(equalTo("Hello World!")));
	}


	@Test
	public void contextLoads() {
	}
}
