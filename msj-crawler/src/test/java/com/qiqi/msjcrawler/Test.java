package com.qiqi.msjcrawler;

public class Test {
    public static void main(String[] args) {
//        System.out.println(Test2.n);

//        String s1 = "a";
//        String s2 = s1 + "b";
//        String s3 = "a" + "b";
//        System.out.println(s2 == "ab");//false
//        System.out.println(s3 == "ab");//true

//        System.out.println(test());
    }

    static int test() throws RuntimeException {
        int x = 1;
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            ++x;
        }
    }

}

class Test2 {
    public static final int n = 2;

    public static final String str;

    static {
        str = "";
        System.out.println("test");
    }

    Test2(){
    }

    public void f1(){
    }
}

abstract class Fu {
    public void test() {
    }

    public void asd() {
    }
}

interface A {
    int i = 0;
}

class B {
    int i = 0;
}

class C extends B implements A {
    public void pX() {
        System.out.println(super.i);
    }
}

interface Playable {
    void play();
}

interface Bounceable {
    void play();
}

interface Rollable extends Playable, Bounceable {
    Ball ball = new Ball("PingPang");
}

class Ball implements Rollable {
    private String name;

    public String getName() {
        return name;
    }

    public Ball(String name) {
        this.name = name;
    }

    public void play() {
//        ball = new Ball("Football");
        System.out.println(ball.getName());
    }
}

class E{
    public void e(){
        F f = new F();
    }
}

class F extends E{}