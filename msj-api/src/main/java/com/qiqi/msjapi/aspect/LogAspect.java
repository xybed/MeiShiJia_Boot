package com.qiqi.msjapi.aspect;

import com.alibaba.fastjson.JSON;
import com.qiqi.msjapi.core.Result;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * com.qiqi.msjapi.controller.*.*(..))")
    public void requestLog(){}

    @Before("requestLog()")
    public void doBefore(JoinPoint joinPoint){
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        logger.info("请求URL :" + request.getRequestURL().toString());
        logger.info("请求方式Method：" + request.getMethod());
        logger.info("请求IP：" + request.getRemoteAddr());
        logger.info("方法：" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS：" + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "result", pointcut = "requestLog()")
    public void afterReturning(Result result){
        // 处理完请求，返回内容
        logger.info("返回json：" + JSON.toJSONString(result));
    }

    //后置异常通知
    @AfterThrowing("requestLog()")
    public void throwss(JoinPoint jp){
//        System.out.println("方法异常时执行.....");
    }

    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
    @After("requestLog()")
    public void after(JoinPoint jp){
//        System.out.println("方法最后执行.....");
    }

    //环绕通知,环绕增强，相当于MethodInterceptor
//    @Around("requestLog()")
//    public Object around(ProceedingJoinPoint pjp) {
//        System.out.println("方法环绕start.....");
//        try {
//            Object o =  pjp.proceed();
//            System.out.println("方法环绕proceed，结果是 :" + o);
//            return o;
//        } catch (Throwable e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}
