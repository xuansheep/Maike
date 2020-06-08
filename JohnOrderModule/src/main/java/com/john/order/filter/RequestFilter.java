package com.john.order.filter;


import cn.hutool.core.util.IdUtil;
import com.john.order.servlet.RequestWrapper;
import com.john.order.servlet.ResponseWrapper;
import com.john.order.utils.IPUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author xuhang
 * @date 2019/5/23 14:14
 */
@Slf4j
@WebFilter(filterName = "RequestResponseLogFilter", urlPatterns = "/*")
public class RequestFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String path = request.getQueryString();
        String servletPath = request.getServletPath();
        String uri = request.getRequestURI();
        RequestWrapper requestWrapper = null;


        StringBuilder sb = new StringBuilder();
        requestWrapper = new RequestWrapper(request);
        BufferedReader bufferedReader = requestWrapper.getReader();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }

        String ipAddr = IPUtil.getIpAddr(request);
        String uuid = IdUtil.fastSimpleUUID();

        log.debug("");
        log.info("-> request id: {}, uri：{}, ip: {}", uuid, uri, ipAddr);
        log.debug("-> queryString: {}, servletPath: {}", path, servletPath);
        log.debug("-> request param: {}", sb.toString());
        log.debug("");

        ResponseWrapper responseWrapper = new ResponseWrapper(response);

        filterChain.doFilter(requestWrapper, responseWrapper);

        String result = new String(responseWrapper.getResponseData());
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(result.getBytes());
        outputStream.flush();
        outputStream.close();
        // 打印response
        log.debug("");
        log.debug("-> response id: {}, data: {}", uuid, result);
        log.debug("");
    }
}
