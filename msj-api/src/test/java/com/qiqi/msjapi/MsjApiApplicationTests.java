package com.qiqi.msjapi;

import com.qiqi.msjapi.test.AsyncTaskService;
import com.qiqi.msjapi.test.MQSender;
import com.qiqi.msjapi.test.TaskExecutorConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MsjApiApplicationTests {

    @Autowired
    private MQSender sender;

    @Test
    public void contextLoads() {
//        sender.send();
//        sender.sendMessage();
//        sender.sendMessages();
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
