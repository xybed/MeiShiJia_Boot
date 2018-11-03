package com.qiqi.msjcrawler.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentQDemo {
    public static void main(String[] args){
        ConcurrentLinkedQueue<String> concurrentQueue = new ConcurrentLinkedQueue<String>();
        concurrentQueue.offer("张三");
        concurrentQueue.offer("李四");
        concurrentQueue.offer("王二麻子");
        System.out.println(concurrentQueue.poll());
        System.out.println(concurrentQueue.size());
    }
}
