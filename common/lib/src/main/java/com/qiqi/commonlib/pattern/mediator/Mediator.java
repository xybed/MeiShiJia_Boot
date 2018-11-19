package com.qiqi.commonlib.pattern.mediator;

/**
 * 抽象中介者
 */
public abstract class Mediator {
    abstract void contact(String message, Colleague colleague);
}
