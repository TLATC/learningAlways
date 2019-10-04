package com.shawn.eurekaclient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: DcController
 * @Description
 * @author: Shawn Wu
 * @date: 2019/9/23 16:55
 * @version:
 */
@RestController
public class DcController {

    @Autowired
    DiscoveryClient discoveryClient;

    /**
     * @Description 获取当前的服务清单
     * @param
     * @return
     * @date 2019/9/23 17:09
     * @auther Shawn Wu
     */
    @GetMapping("/dc")
    public String dc(){
        String services = "Services：" + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

}