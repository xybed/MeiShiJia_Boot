package com.qiqi.meishijia;

import com.qiqi.meishijia.test.TaskExecutorConfig;
import com.qiqi.meishijia.test.AsyncTaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MeishijiaApplicationTests {

    @Test
    public void contextLoads() {
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
