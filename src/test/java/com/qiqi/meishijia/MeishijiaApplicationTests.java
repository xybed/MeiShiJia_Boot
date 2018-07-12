package com.qiqi.meishijia;

import com.qiqi.meishijia.service.CrawlerService;
import com.qiqi.meishijia.test.MQSender;
import com.qiqi.meishijia.test.TaskExecutorConfig;
import com.qiqi.meishijia.test.AsyncTaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MeishijiaApplicationTests {
    @Autowired
    private MQSender sender;

    @Resource
    private CrawlerService crawlerService;

    @Test
    public void contextLoads() {
//        sender.send();
//        sender.sendMessage();
//        sender.sendMessages();
        crawlerService.getPlayerData();
    }

    public void testAsyncTask(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService service = context.getBean(AsyncTaskService.class);
        for(int i=0;i<10;i++){
            service.executeAsyncTask(i);
            service.executeAsyncTaskPlus(i);
        }
        context.close();
    }

}
