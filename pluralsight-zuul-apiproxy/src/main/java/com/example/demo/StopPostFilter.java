package com.example.demo;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class StopPostFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {

		Instant stop = Instant.now();

		RequestContext ctx = RequestContext.getCurrentContext();
		Instant start = (Instant) ctx.get("starttime");
		long secondsDifference = ChronoUnit.MILLIS.between(start, stop);
		System.out.println("Call took " + secondsDifference + " milliseconds");
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "post";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
