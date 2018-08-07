package com.qiqi.msjback.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthorAspect {

    @Pointcut("@annotation(com.qiqi.msjback.annotation.Authority)")
    public void queryOnly(){}

    @Before("queryOnly()")
    public void doBefore(){}
}
