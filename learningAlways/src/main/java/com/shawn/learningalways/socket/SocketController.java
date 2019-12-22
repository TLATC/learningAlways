package com.shawn.learningalways.socket;

import com.shawn.learningalways.base.controller.BaseController;
import com.shawn.learningalways.base.model.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * socket服务端口
     */
    private int port = 5555;


    /**
     * @Description 启动socket服务
     * @param
     * @return
     * @date 2019/12/22 15:53
     * @auther Shawn Wu
     */
    @GetMapping(value = "serverStart")
    public void startSocketServer(){
        /*
         * 启动服务端监听
         */
        EchoMultiServer server = new EchoMultiServer();
        server.start(port);
    }


    /**
     * @Description 启动socket客户端
     * @param
     * @return 
     * @date 2019/12/22 15:56
     * @auther Shawn Wu
     */
    @GetMapping(value = "clientStart")
    public JsonResult startSocketClient(){

        for(int i=0; i<5; i++){
            // 启5个线程，模拟建立5个客户端连接
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    EchoClient client = new EchoClient();
                    client.startConnection("127.0.0.1", port);
                    String msg1 = client.sendMessage("这是第x个客户端发来的socket消息");
                    System.out.println("收到服务端的返回是："+msg1);
                    String msg2 = client.sendMessage(".");
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