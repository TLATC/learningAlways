package com.shawn.learningalways.netty.client;

import com.shawn.learningalways.base.conf.model.NettyYmlProperties;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

/**
 * TradeClient
 * netty客户端
 *
 * @author Shawn Wu
 * @date 2020/9/24 9:59
 * @since v1
 */
@Component
public class TradeClient {

    /**
     * netty配置文件类
     */
    private final NettyYmlProperties nettyYmlProperties;

    @Autowired
    public TradeClient(NettyYmlProperties nettyYmlProperties) {
        this.nettyYmlProperties = nettyYmlProperties;
    }


    /**
     * 开启netty客户端
     *
     * @param serverHost 要连接的服务端地址
     * @param serverPort 要连接的服务端的端口
     * @param tradeMsg 交易报文
     * @date 2020/9/24 15:21
     * @author Shawn Wu
     */
    public void startClient(String serverHost, int serverPort, String tradeMsg) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        // Bootstrap用于引导客户端或者无连接服务器
        Bootstrap bootstrap = new Bootstrap();
        try {
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    // 指定远程服务地址
                    .remoteAddress(new InetSocketAddress(serverHost, serverPort))
                    // 初始化通道，设置处理类
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) {
                            socketChannel.pipeline().addLast(new TradeClientHandler(nettyYmlProperties, tradeMsg));
                        }
                    });
            // 解析远程域名并异步连接
            ChannelFuture f = bootstrap.connect().sync();
            // 等待客户端连接端口关闭
            f.channel().closeFuture().sync();
        } finally {
            // 优雅关闭线程组
            group.shutdownGracefully().sync();
        }
    }
}