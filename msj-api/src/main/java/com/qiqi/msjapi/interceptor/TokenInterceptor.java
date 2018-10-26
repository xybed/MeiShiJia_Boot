package com.qiqi.msjapi.interceptor;

import com.alibaba.fastjson.JSON;
import com.qiqi.msjapi.utils.JWTUtil;
import com.qiqi.commonlib.annotation.NeedLogin;
import com.qiqi.commonlib.common.Result;
import com.qiqi.commonlib.common.ResultEnum;
import com.qiqi.msjapi.service.UserTokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class TokenInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            HandlerMethod method = (HandlerMethod) handler;
            NeedLogin needLogin = method.getMethodAnnotation(NeedLogin.class);
            if(needLogin != null){
                String token = request.getHeader("token");
                if(token != null){
                    Claims claims = JWTUtil.getClaims(token);
                    String username = claims.getSubject();
                    Date expiration = claims.getExpiration();
                    long currentTime = System.currentTimeMillis();
                    //时间过期
                    if(expiration.getTime() < currentTime){
                        responseResult(response);
                        return false;
                    }
                    WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
                    UserTokenService userTokenService = applicationContext.getBean("userTokenService", UserTokenService.class);
                    String tokenDB = userTokenService.queryToken(username);
                    if(!token.equals(tokenDB)){
                        responseResult(response);
                        return false;
                    }else {
                        return true;
                    }
                }else {
                    //token为空
                    responseResult(response);
                    return false;
                }
            }
        }catch (ClassCastException e){
            logger.info("ClassCastException:" + request.getRequestURL().toString());
        }catch (ExpiredJwtException|SignatureException e){
            responseResult(response);
            return false;
        }
        return super.preHandle(request, response, handler);
    }

    private void responseResult(HttpServletResponse response) {
        Result result = new Result();
        result.setCode(ResultEnum.TOKEN_ERROR.getCode())
                .setMessage(ResultEnum.TOKEN_ERROR.getMsg());
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(JSON.toJSONString(result));
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }
}
