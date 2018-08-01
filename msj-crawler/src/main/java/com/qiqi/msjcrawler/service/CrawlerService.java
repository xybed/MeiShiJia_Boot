package com.qiqi.msjcrawler.service;

public interface CrawlerService {
    void getPlayerData();

    void getProductData(String html, int categoryId);

    void getProductDetail(String url, String price, String remark);
}
