package com.shawn.learningalways.base.constant;

/**
 * 系统名称: learningAlways
 * 模块名称: redis订阅频道枚举类
 * 类 名 称: RedisChannelEnum
 * 软件版权: Jones
 * 功能说明：
 * 系统版本：v1.0.1
 * 开发人员: Jones
 * 开发时间: 2018/6/20 22:11
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
public enum RedisChannelEnum {

    /**
     * redis订阅频道1
     */
    REDIS_CHANNEL_TEST1("channel1","redis订阅频道1"),
    /**
     * redis订阅频道2
     */
    REDIS_CHANNEL_TEST2("channel2","redis订阅频道2"),
    /**
     * redis超时任务频道 todo:默认的？
     */
//    REDIS_CHANNEL_REDISEXPIRED("__keyevent@0__:expired","redis超时任务频道"),
    /**
     * redis订阅频道3
     */
    REDIS_CHANNEL_TEST3("channel3","redis订阅频道3");


    /**
     * redis频道
     */
    private final String channel;
    /**
     * redis频道说明
     */
    private final String desc;

    public String getChannel() {
        return channel;
    }

    public String getDesc() {
        return desc;
    }

    /**
     * 私有构造函数
     * @param channel redis频道
     * @param desc redis频道说明
     */
    RedisChannelEnum(String channel, String desc){
        this.channel = channel;
        this.desc = desc;
    }


    public static void main(String[] args) {

        System.out.println("直接获取redis订阅频道1：" + RedisChannelEnum.REDIS_CHANNEL_TEST1.getChannel());
        System.out.println("");

        System.out.println("------------------遍历获取枚举值---------------------");
        //遍历所有的枚举值
        for(RedisChannelEnum e : RedisChannelEnum.values()){
            System.out.print("redis订阅频道名：" + e.getChannel());
            System.out.println("          redis频道描述：" + e.getDesc());
        }
    }
}
