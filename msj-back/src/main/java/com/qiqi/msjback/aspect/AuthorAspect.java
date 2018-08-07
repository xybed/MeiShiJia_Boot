package com.qiqi.msjback.aspect;

import com.qiqi.msjmapper.pojo.Pagination;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthorAspect {

    @Pointcut("@annotation(com.qiqi.msjback.annotation.Authority)")
    public void queryOnly(){}

    @Before("queryOnly() && args(objectCustom, grid)")
    public void doBefore(Object objectCustom, Pagination grid){

    }
}
