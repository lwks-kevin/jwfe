package com.kvnl.jwfe.security.csrf;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kvnl.jwfe.security.csrf.annotation.CsrfTag;

public abstract class CsrfFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String reqMethod = httpRequest.getMethod();
		if (reqMethod.matches("HEAD") || reqMethod.matches("TRACE") || reqMethod.matches("OPTIONS")) {
			// ignore 
			chain.doFilter(request, response);
			return;
		} else {
			doFilterProccess(httpRequest,httpResponse, chain);
		}
	}
	
	abstract protected void doFilterProccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException;

	protected boolean doValidate(HttpServletRequest request, HttpServletResponse response, HashSet<CsrfTag> hashsetCsrfTag) {
		String reqMethod = request.getMethod();
		String reqUrl = request.getRequestURI();
		String contextPath = request.getContextPath();
		CsrfTag matchCsrfTag = null;
		for (CsrfTag csrfTag : hashsetCsrfTag) {
			if (reqMethod.equals(csrfTag.requestMethod().toString())) {
				if (reqUrl.matches(contextPath + csrfTag.urlPattern())) {
					matchCsrfTag = csrfTag;
					break;
				}
			}
		}
		if (matchCsrfTag == null) {
			// not match, ignore
			return true;
		}
		String inputParamsName = CsrfProtectionProvider.getInstance().getReqParamsKeyCsrf();
		String inputToken = request.getParameter(inputParamsName);
		String key = matchCsrfTag.key();
		String storageToken = CsrfProtectionProvider.getInstance().getCsrfValidator().loadToken(request, response, key);
		boolean allow = CsrfProtectionProvider.getInstance().getCsrfValidator().validateToken(inputToken, storageToken);
		if (allow) {
			if (matchCsrfTag.once()) {
				CsrfProtectionProvider.getInstance().getCsrfValidator().clearToken(request, response, key);
			}
		}
		return allow;
	}
	
	protected void doAccessDenied(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		String message = "AccessDenied";
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.write(message);
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}
	
}

