package com.shawn.learningalways.netty.controller;

import com.alibaba.fastjson.JSONObject;
import com.shawn.learningalways.base.conf.model.NettyYmlProperties;
import com.shawn.learningalways.base.controller.BaseRender;
import com.shawn.learningalways.base.model.JsonResult;
import com.shawn.learningalways.socket.EchoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.UUID;

/**
 * NettyController
 * netty控制层
 *
 * @author Shawn Wu
 * @date 2020/9/14 17:43
 * @since v1
 */
@RestController
@RequestMapping("netty")
public class NettyController extends BaseRender{
    private static final Logger LOGGER = LoggerFactory.getLogger(NettyController.class);

    /**
     * netty配置文件类
     */
    @Autowired
    private NettyYmlProperties nettyYmlProperties;


    /**
     * 启动传统的socket客户端
     *
     * @param serverIp 服务端ip
     * @param serverPort 服务端端口
     * @date 2020/3/4 17:18
     * @author Shawn Wu
     */
    private void socketClientStart(String serverIp, int serverPort){
        // 开启socket客户端
        EchoClient client = new EchoClient();
        client.startConnection(serverIp, serverPort);

        // 报文体长度
        String length = "00001000";
        // 交易码
        Random random = new Random();
        random.nextInt(2);
        String tradeCode = random.nextInt(2)==0?"20001":"20002";
        // 交易流水号
        String tradeSeqNo = UUID.randomUUID().toString().replaceAll("-", "");
        /*
         * 构造请求报文
         */
        JSONObject reqObj = new JSONObject();
        reqObj.put("tradeCode", tradeCode);
        reqObj.put("tradeSeqNo", tradeSeqNo);
        String reqMsg = length + reqObj.toJSONString();
        // 发送报文请求
        String tradeResult = client.sendMessage(reqMsg);
        LOGGER.debug("收到服务端的返回是：{}", tradeResult);
        // 关闭socket客户端
        client.stopConnection();
    }

    /**
     * 单客户端启动
     * 发消息给netty服务端，传统socket版实现客户端
     *
     * @return result
     * @date 2020/9/10 16:37
     * @author Shawn Wu
     */
    @GetMapping(value = "singleSocketClientStart")
    public JsonResult singleSocketClientStart() {
        Runnable task = () -> socketClientStart("127.0.0.1", nettyYmlProperties.getServerPort());
        Thread thread = new Thread(task);
        thread.start();
        return renderSuccess();
    }

    /**
     * 多客户端启动
     * 发消息给netty服务端，传统socket版实现客户端
     *
     * @param jsonString num 客户端数量
     * @return 结果
     * @date 2020/9/10 17:08
     * @author Shawn Wu
     */
    @PostMapping(value = "batchSocketClientStart")
    public JsonResult batchSocketClientStart(@RequestBody String jsonString){
        JSONObject reqObj = JSONObject.parseObject(jsonString);
        int num = reqObj.getInteger("num");

        // 启5个线程，模拟建立多个客户端连接
        for(int i=0; i<num; i++){
            Runnable task = () -> socketClientStart("127.0.0.1", nettyYmlProperties.getServerPort());
            Thread thread = new Thread(task);
            thread.start();
        }
        return renderSuccess();
    }
}