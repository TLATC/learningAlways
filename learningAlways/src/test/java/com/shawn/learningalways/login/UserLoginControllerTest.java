package com.shawn.learningalways.login;

import com.alibaba.fastjson.JSON;
import com.shawn.learningalways.LearningAlwaysApplication;
import com.shawn.learningalways.base.model.JsonResult;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @ClassName: UserLoginControllerTest
 * @Description 用户登录控制层测试
 * @author: Shawn Wu
 * @date: 2019/12/17 19:33
 * @version:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LearningAlwaysApplication.class)
public class UserLoginControllerTest {

    @Autowired
    private WebApplicationContext wac;

    /**
     * 模拟mvc请求
     */
    private MockMvc mockMvc;


    /**
     * @Description 初始化MockMvc
     * @param
     * @return 
     * @date 2019/12/17 19:38
     * @auther Shawn Wu
     */
    @Before
    public void init(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }


    /**
     * @Description 测试职员登录
     *              正案例
     * @param
     * @return
     * @date 2019/12/17 19:52
     * @auther Shawn Wu
     */
    @Test
    public void userLogin1() throws Exception{
        // 传入参数
        Map<String, Object> params = new HashMap<>();
        params.put("name", "xxx");
        // 调用接口/userLogin/staff
        MvcResult result = mockMvc.perform(post("/userLogin/staff")
                // 参数赋值
                .content(JSON.toJSONString(params))
                // 传参格式为json
                .contentType(MediaType.APPLICATION_JSON))
                // 期望接口状态为ok
                .andExpect(status().isOk())
                // 期望返回格式为json格式，UTF-8编码
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();
        // 解析返回结果
        JsonResult jsonResult = JSON.parseObject(result.getResponse().getContentAsString(), JsonResult.class);
        System.out.println("返回结果是：" + jsonResult);
        // 如果返回结果中success为true，则通过
        assert jsonResult.isSuccess();
        // 如果返回结果中status为200，则通过
        assert String.valueOf(HttpStatus.OK.value()).equals(jsonResult.getStatus());
    }


    /**
     * @Description 测试职员登录
     *              反向案例：传入空名字
     * @param
     * @return 
     * @date 2019/12/17 20:37
     * @auther Shawn Wu
     */
    @Test
    public void userLogin2() throws Exception{
        // 传入参数
        Map<String, Object> params = new HashMap<>();
        params.put("name", "");
        // 调用接口/userLogin/staff
        MvcResult result = mockMvc.perform(post("/userLogin/staff")
                // 参数赋值
                .content(JSON.toJSONString(params))
                // 传参格式为json
                .contentType(MediaType.APPLICATION_JSON))
                // 期望接口状态为ok
                .andExpect(status().isOk())
                // 期望返回格式为json格式，UTF-8编码
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();
        // 解析返回结果
        JsonResult jsonResult = JSON.parseObject(result.getResponse().getContentAsString(), JsonResult.class);
        System.out.println("返回结果是：" + jsonResult);
        // 预期 返回结果中success为false
        assert !jsonResult.isSuccess();
        // 预期 返回结果中status为500
        assert String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()).equals(jsonResult.getStatus());
    }
}