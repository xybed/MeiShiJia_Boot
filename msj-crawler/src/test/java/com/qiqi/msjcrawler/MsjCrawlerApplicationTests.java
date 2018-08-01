package com.qiqi.msjcrawler;

import com.qiqi.msjcrawler.service.CrawlerService;
import com.qiqi.msjcrawler.service.impl.CrawlerServiceImpl;
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
        crawlerService.getPlayerData();
//        crawlerService.getProductData("/view/test.html", 462);
//        crawlerService.getProductData("/view/test1.html", 457);
//        crawlerService.getProductData("/view/test2.html", 458);
//        crawlerService.getProductData("/view/test3.html", 459);
//        crawlerService.getProductData("/view/test4.html", 460);
    }

}
