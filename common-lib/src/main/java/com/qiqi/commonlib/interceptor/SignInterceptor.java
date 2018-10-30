package com.qiqi.commonlib.interceptor;

import com.alibaba.fastjson.JSON;
import com.qiqi.commonlib.utils.MD5Util;
import com.qiqi.commonlib.common.Result;
import com.qiqi.commonlib.common.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SignInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String SIGN_KEY = "MeiShiJia";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //验证签名
        boolean pass = validateSign(request);
        if (pass) {
            return true;
        } else {
            logger.warn("签名认证失败，请求接口：{}，请求IP：{}，请求参数：{}",
                    request.getRequestURI(), getIpAddress(request), JSON.toJSONString(request.getParameterMap()));

            Result result = new Result();
            result.setCode(ResultEnum.SIGN_FAIL.getCode()).setMessage(ResultEnum.SIGN_FAIL.getMsg());
            responseResult(response, result);
            return false;
        }
    }

    /**
     * 验证sign的有效性，保证请求是安全无恶意的
     * @param request 请求体
     * @return 安全则返回true，反之为false
     */
    private boolean validateSign(HttpServletRequest request) throws IOException {
        String sign = request.getHeader("sign");
        if("sign".equals(sign))
            return true;
//        if(StringUtil.isEmpty(sign))
//            return false;
        Map<String, String> paramsMap = new HashMap<>();
        if("POST".equals(request.getMethod())){
            int len = request.getContentLength();
            ServletInputStream is = request.getInputStream();
            byte[] buffer = new byte[len];
            is.read(buffer, 0, len);
            String body = new String(buffer, "UTF-8");
            paramsMap = (Map<String, String>) JSON.parse(body);
            is.close();
        }
        for(String key : request.getParameterMap().keySet()){
            paramsMap.put(key, request.getParameterMap().get(key)[0]);
        }
        paramsMap.put("ver", request.getHeader("ver"));
        paramsMap.put("platform", request.getHeader("platform"));
        paramsMap.put("token", request.getHeader("token"));
        return sign.equals(MD5Util.createParamSign(paramsMap, SIGN_KEY));
    }

    private String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        // 如果是多级代理，那么取第一个ip为客户端ip
        if (ip != null && ip.contains(",")) {
            ip = ip.substring(0, ip.indexOf(",")).trim();
        }
        return ip;
    }

    private void responseResult(HttpServletResponse response, Result result) {
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
