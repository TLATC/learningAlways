package com.shawn.eurekaconsumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName: DcFeignClient
 * @Description Feign的客户端接口定义
 * @author: Shawn Wu
 * @date: 2019/10/5 10:10
 * @version:
 */
@FeignClient("eureka-client")
public interface DcFeignClient {

    /**
     * @Description 调用eureka-client服务的dc接口
     * @param
     * @return
     * @date 2019/10/5 10:12
     * @auther Shawn Wu
     */
    @GetMapping("/eclient/dc")
    String feginConsumer();
}
