package com.qiqi.meishijia;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.qiqi.meishijia.common.Sex;
import com.qiqi.meishijia.service.CrawlerService;
import com.qiqi.meishijia.test.AsyncTaskService;
import com.qiqi.meishijia.test.MQSender;
import com.qiqi.meishijia.test.TaskExecutorConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MeishijiaApplicationTests {
    @Autowired
    private MQSender sender;

    @Resource
    private CrawlerService crawlerService;

    @Test
    public void contextLoads() throws Exception {
//        sender.send();
//        sender.sendMessage();
//        sender.sendMessages();
//        crawlerService.getPlayerData();
//        crawlerService.getProductData();
        crawlerService.getProductDetail("https://item.jd.com/3433317.html", "3099.00",
                "【727全民不上街，电视宅购节！下方领券减100，2999成交！】超薄机身设计，2G+16G大内存，人工智能，客厅里的IMAX！更多优惠详情点击");
    }

    @Test
    public void testBigDecimal(){
        BigDecimal bd1 = BigDecimal.valueOf(0.01);
        BigDecimal bd2 = BigDecimal.valueOf(100);
        System.out.println(bd1.multiply(bd2).intValue());
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
