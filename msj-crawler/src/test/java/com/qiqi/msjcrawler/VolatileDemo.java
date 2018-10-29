package com.qiqi.msjcrawler;

public class VolatileDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadVolatile threadVolatile = new ThreadVolatile();
        threadVolatile.start();
        Thread.sleep(3000);
        //主线程修改共享全局变量为false
        threadVolatile.setFlag(false);
        System.out.println("flag已经修改为false");
        Thread.sleep(1000);
        System.out.println(threadVolatile.flag);
    }
}

class ThreadVolatile extends Thread{

    //如果没有volatile（保证可见性的关键字），主线程修改flag后，没有刷新到线程的本地私有内存中
    //导致while循环中的flag还为true
    public volatile boolean flag = true;

    @Override
    public void run() {
        System.out.println("线程开始执行");
        while (flag){}
        System.out.println("线程结束执行");
    }

    public void setFlag(boolean flag){
        this.flag = flag;
    }
}
