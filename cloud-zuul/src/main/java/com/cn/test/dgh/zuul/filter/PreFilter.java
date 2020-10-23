package com.cn.test.dgh.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.Configuration;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;

@Slf4j
@Configuration
public class PreFilter extends ZuulFilter {


    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    public int filterOrder() {
        return 0;
    }

    public boolean shouldFilter() {
        return true;
    }

    public Object run() throws ZuulException {

        StringBuffer url=getCurrentContext().getRequest().getRequestURL();
        log.info("PreFilter [{}]",url);

        return null;
    }
}
