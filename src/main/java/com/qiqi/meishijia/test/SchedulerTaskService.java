package com.qiqi.meishijia.test;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class SchedulerTaskService {

    private static final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("每隔5秒执行一次："+format.format(new Date()));
    }

    @Scheduled(cron = "0 04 16 ? * *")
    public void fixTimeExecution(){
        System.out.println("在指定时间："+format.format(new Date())+"执行");
    }
}
