package com.shawn.eurekaconsumer.controller;

import com.shawn.eurekaconsumer.service.DcFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: DcController
 * @Description 服务消费控制层
 * @author: Shawn Wu
 * @date: 2019/9/23 17:42
 * @version:
 */
@RestController
public class DcController {

    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    DcFeignClient dcFeignClient;

    /**
     * @Description 消费服务
     * @param
     * @return
     * @date 2019/9/23 17:58
     * @auther Shawn Wu
     */
    @GetMapping("/consumer")
    public String dc(){
        // 使用loadBalancerClient调用
//        return loadBalancerConsumer();

        // 使用Ribbon调用
//        return RibbonConsumer();

        // 使用fegin调用
        return  feginConsumer();
    }

    /**
     * @Description 使用loadBalancerClient调用
     * @param
     * @return
     * @date 2019/10/5 10:29
     * @auther Shawn Wu
     */
    private String loadBalancerConsumer(){
        // 用loadBalancerClient负载均衡的选出一个eureka-client的服务实例
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        // 拼接出接口url
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/eclient/dc";
        System.out.println("要调用的url是：" + url);
        return  restTemplate.getForObject(url, String.class);
    }

    /**
     * @Description 使用Ribbon调用
     * @param
     * @return 
     * @date 2019/10/5 10:31
     * @auther Shawn Wu
     */
    private String RibbonConsumer(){
        // 用服务名，而不用ip和端口
        String url = "http://eureka-client/eclient/dc";
        System.out.println("要调用的url是：" + url);
        return  restTemplate.getForObject(url, String.class);
    }

    /**
     * @Description 使用fegin调用
     * @param
     * @return 
     * @date 2019/10/5 10:16
     * @auther Shawn Wu
     */
    private String feginConsumer(){
        return dcFeignClient.feginConsumer();
    }
}