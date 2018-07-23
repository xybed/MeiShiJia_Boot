package com.qiqi.meishijia.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "httpServletRequestReplacedFilter", urlPatterns = "/*",
        initParams={
                @WebInitParam(name="exclusions",value="/upload/image")// 忽略资源
        })
public class HttpServletRequestReplacedFilter implements Filter {

    private String[] excludeUrls;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String exclusions = filterConfig.getInitParameter("exclusions");
        excludeUrls = exclusions.split(",");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        ServletRequest requestWrapper = null;
        if(request instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            String path = httpServletRequest.getRequestURI();
            if(!path.equals(excludeUrls[0])){
                requestWrapper = new MyHttpServletRequestWrapper(httpServletRequest);
            }
        }
        if(requestWrapper == null) {
            chain.doFilter(request, response);
        } else {
            chain.doFilter(requestWrapper, response);
        }
    }

    @Override
    public void destroy() {

    }
}
