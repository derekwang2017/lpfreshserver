package com.lpfresh.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 87831 on 2018/1/25/0025.
 */
@Component
public class CrosFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) res;
        //测试环境用【*】匹配，上生产环境后需要切换为实际的前端请求地址
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");

        response.setHeader("Access-Control-Max-Age", "0");

        response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With, auth");

        response.setHeader("Access-Control-Allow-Credentials", "true");

        response.setHeader("XDomainRequestAllowed","1");
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }
}
