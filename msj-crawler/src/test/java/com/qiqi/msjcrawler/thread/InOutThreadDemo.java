package com.qiqi.msjcrawler.thread;

/**
 * 线程之间的通讯wait()、notify()、notifyAll()
 */
public class InOutThreadDemo {
    public static void main(String[] args){
        Res res = new Res();
        OutputThread out = new OutputThread(res);
        InputThread in = new InputThread(res);
        out.start();
        in.start();
    }
}

class Res{
    public String name;
    public String sex;
    public boolean flag;//false的时候做写，true的时候做读
}

class OutputThread extends Thread{
    private Res res;

    public OutputThread(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        int count = 0;
        while (true){
            synchronized (res){
                //如果标志为true，当前res锁调用wait，持有该对象的线程把该对象的控制权交出去，然后处于等待状态，即out线程处于等待状态
                if(res.flag){
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(count == 0){
                    res.name = "皇马";
                    res.sex = "男";
                }else {
                    res.name = "巴萨";
                    res.sex = "女";
                }
                count = (count+1)%2;
                res.flag = true;//写完设成读的标志
                res.notify();//唤醒其他线程
            }
        }
    }
}

class InputThread extends Thread{
    private Res res;

    public InputThread(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true){
            synchronized (res){
                //与上面的写相反
                if(!res.flag){
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(res.name + "   " + res.sex);
                res.flag = false;//读完设成写的标志
                res.notify();//唤醒其他线程
            }
        }
    }
}
