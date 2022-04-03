package com.kvnl.jwfe.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kvnl.jwfe.security.csrf.CsrfFilter;
import com.kvnl.jwfe.security.csrf.CsrfProtectionProvider;
import com.kvnl.jwfe.security.csrf.annotation.CsrfTag;


@WebFilter(urlPatterns = {"/*"}, dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})
public class TestCsrfFilter extends CsrfFilter {

	private HashSet<CsrfTag> hashsetCsrfTag = new HashSet<CsrfTag>();
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		hashsetCsrfTag = CsrfProtectionProvider.getInstance().getCsrfAnnotationClassReflector().reflectAnnotationClass(TestCsrfServlet.class);
	}
	
	@Override
	public void destroy() {
		hashsetCsrfTag.clear();
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		super.doFilter(request, response, chain);
	}
	
	@Override
	protected void doFilterProccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String reqMethod = request.getMethod();
		if (reqMethod.matches("GET")) {
			// ignore 
			chain.doFilter(request, response);
			return;
		} else {
			boolean allow = doValidate(request,response,hashsetCsrfTag);
			if (allow) {
				chain.doFilter(request, response);
				return;
			} else {
				doAccessDenied(request, response);
				return;
			}
		}
	}
	
	@Override
	protected boolean doValidate(HttpServletRequest request, HttpServletResponse response,
			HashSet<CsrfTag> hashsetCsrfTag) {
		return super.doValidate(request, response, hashsetCsrfTag);
	}
	
	@Override
	protected void doAccessDenied(HttpServletRequest request, HttpServletResponse response) {
		super.doAccessDenied(request, response);
	}
	
}
