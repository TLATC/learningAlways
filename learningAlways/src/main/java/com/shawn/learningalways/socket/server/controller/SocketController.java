package com.shawn.learningalways.socket.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.shawn.learningalways.base.controller.BaseRender;
import com.shawn.learningalways.base.model.JsonResult;
import com.shawn.learningalways.socket.EchoClient;
import com.shawn.learningalways.socket.model.SocketConf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class SocketController extends BaseRender {

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
     * @param serverIp 服务端ip
     * @return 
     * @date 2020/3/4 17:18
     * @author Shawn Wu
     */
    private void socketClientStart(String serverIp){

        // 开启socket客户端
        EchoClient client = new EchoClient();
        client.startConnection(serverIp, socketConf.getPort());

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

    /**
     * @Description 启动socket客户端
     * @param
     * @return 
     * @date 2019/12/22 15:56
     * @auther Shawn Wu
     */
    @PostMapping(value = "batchClientStart")
    public JsonResult batchClientStart(@RequestBody String jsonString){
        JSONObject reqObj = JSONObject.parseObject(jsonString);
        int num = reqObj.getInteger("num");

        // 启5个线程，模拟建立多个客户端连接
        for(int i=0; i<num; i++){
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    socketClientStart("127.0.0.1");
                }
            };
            Thread thread = new Thread(task);
            thread.start();
        }
        return renderSuccess();
    }

    /**
     * @Description 单客户端启动
     * @param
     * @return 
     * @date 2020/3/4 17:12
     * @author Shawn Wu
     */
    @GetMapping(value = "singleClientStart")
    public JsonResult singleClientStart() {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                socketClientStart("127.0.0.1");
            }
        };
        Thread thread = new Thread(task);
        thread.start();

        return renderSuccess();
    }

}