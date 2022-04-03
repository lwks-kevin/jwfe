package com.kvnl.jwfe.security.csrf.tld;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.kvnl.jwfe.security.csrf.CsrfProtectionProvider;

public class CsrfViewTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	private String key = null;
	
	public String getKey() {
		return this.key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public int doStartTag() throws JspException {
		String token = CsrfProtectionProvider.getInstance().getCsrfValidator().generateToken();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
		CsrfProtectionProvider.getInstance().getCsrfValidator().saveToken(request, response, key, token);
		
		JspWriter out = pageContext.getOut();
		String strCsrfInputHtml = genCsrfInputHtml(token);
		try {
			out.println(strCsrfInputHtml);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return SKIP_BODY;
	}
	
	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
	
	private String genCsrfInputHtml(String token) {
		String inputParamsName = CsrfProtectionProvider.getInstance().getCsrfReqParamsKey();
		return String.format("<input type=\"hidden\" name=\"%s\" value=\"%s\"/>", inputParamsName, token);
	}
	
}
