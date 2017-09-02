package com.trivadis.techevent.springclouddemo.zuul;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class DemoFilter extends ZuulFilter {
	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	public boolean shouldFilter() {
		return true;
	}
	
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
        ctx.addZuulRequestHeader("DEMOHEADER", "SOME-VALUE-123");
        return null;
	}

}
