package com.jones.myspringboot.example.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 系统名称: mySpringBoot
 * 模块名称: 测试模块
 * 类 名 称: ScheduledTasks
 * 软件版权: Jones
 * 功能说明：定时任务类
 * 系统版本：v1.0.1
 * 开发人员: Jones
 * 开发时间: 2018/7/14 16:05
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@Component
public class ScheduledTasks {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

    /**
     * 每隔5秒执行一次
     */
//    @Scheduled(fixedRate = 5000)
//    public void reportCurrentTime(){
//        System.out.println("当前时间是：" + DATE_FORMAT.format(new Date()));
//    }
}
