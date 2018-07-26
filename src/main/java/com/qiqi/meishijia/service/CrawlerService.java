package com.qiqi.meishijia.service;

public interface CrawlerService {
    void getPlayerData();

    void getProductData();

    void getProductDetail(String url);
}
