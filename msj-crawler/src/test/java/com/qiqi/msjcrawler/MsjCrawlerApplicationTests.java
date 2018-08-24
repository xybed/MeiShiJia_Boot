package com.qiqi.msjcrawler;

import com.qiqi.msjcrawler.service.CrawlerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MsjCrawlerApplicationTests {

    @Resource
    private CrawlerService crawlerService;

    @Test
    public void contextLoads() {
//        crawlerService.getPlayerData();
//        crawlerService.getProductData("/view/test1.html", 526);
        crawlerService.getProductData("/view/test2.html", 527);
//        crawlerService.getProductData("/view/test3.html", 523);
//        crawlerService.getProductData("/view/test4.html", 524);
//        crawlerService.getProductData("/view/test5.html", 525);
    }

}
