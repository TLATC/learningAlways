package com.shawn.eurekaconsumer;

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

    /**
     * @Description 消费服务
     * @param
     * @return
     * @date 2019/9/23 17:58
     * @auther Shawn Wu
     */
    @GetMapping("/consumer")
    public String dc(){
        /// 用loadBalancerClient负载均衡的选出一个eureka-client的服务实例
//        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        // 拼接出接口url
//        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/eclient/dc";

        // 用服务名，而不用ip和端口
        String url = "http://eureka-client/eclient/dc";
        System.out.println("要调用的url是：" + url);
        return  restTemplate.getForObject(url, String.class);
    }
}