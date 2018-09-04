package com.qiqi.msjcrawler;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadTrain threadTrain = new ThreadTrain();
        Thread t1 = new Thread(threadTrain, "窗口1");
        Thread t2 = new Thread(threadTrain, "窗口2");
        t1.start();
        t2.start();
    }
}

class ThreadTrain implements Runnable{

    private int ticketCount = 100;
    private Object object = new Object();

    @Override
    public void run() {
        while (ticketCount > 0){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            synchronized (this){
//                if(ticketCount > 0){
//                    System.out.println(Thread.currentThread().getName()+":卖出第"+(100-ticketCount+1)+"张票");
//                    ticketCount--;
//                }
//            }
            sale();
        }
    }

    //同步函数使用this锁
    //静态同步函数使用class的字节码文件（ThreadTrain.class）
    private synchronized void sale(){
        if(ticketCount > 0){
            System.out.println(Thread.currentThread().getName()+":卖出第"+(100-ticketCount+1)+"张票");
            ticketCount--;
        }
    }
}

/**多线程三大特性
 * 原子性：独一无二、一致性 保证线程安全问题
 * 可见性：
 * 有序性：
*/