package com.shawn.learningalways.socket.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.shawn.learningalways.base.controller.BaseController;
import com.shawn.learningalways.base.model.JsonResult;
import com.shawn.learningalways.socket.EchoClient;
import com.shawn.learningalways.socket.model.SocketConf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;

/**
 * @ClassName: SocketController
 * @Description socket消息测试
 * @author: Shawn Wu
 * @date: 2019/12/22 15:52
 * @version:
 */
@RestController
@RequestMapping(value = "socket")
public class SocketController extends BaseController {

    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SocketController.class);

    /**
     * socket配置类
     */
    @Autowired
    private SocketConf socketConf;



    /**
     * @Description 启动socket客户端
     * @param
     * @return 
     * @date 2019/12/22 15:56
     * @auther Shawn Wu
     */
    @GetMapping(value = "clientStart")
    public JsonResult startSocketClient(){

        // 启5个线程，模拟建立5个客户端连接
        for(int i=0; i<5; i++){
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    // 开启socket客户端
                    EchoClient client = new EchoClient();
                    client.startConnection("127.0.0.1", socketConf.getPort());

                    // 报文体长度
                    String length = "00001000";
                    // 交易码
                    Random random = new Random();
                    random.nextInt(2);
                    String tradeCode = random.nextInt(2)==0?"10001":"10002";
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
            };
            Thread thread = new Thread(task);
            thread.start();
        }
        return renderSuccess();
    }
}