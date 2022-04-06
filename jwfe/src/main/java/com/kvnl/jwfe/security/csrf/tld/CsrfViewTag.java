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

	private String key;
	
	private boolean isGenEl;
	
	public String getKey() {
		return this.key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public boolean getIsGenEl() {
		return isGenEl;
	}

	public void setIsGenEl(boolean isGenEl) {
		this.isGenEl = isGenEl;
	}

	@Override
	public int doStartTag() throws JspException {
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
		String token = genRandomCsrfToken();
		request.setAttribute(getReqAttrsCsrfKey(), key);
		request.setAttribute(getReqAttrsKeyCsrfValue(), token);
		CsrfProtectionProvider.getInstance().getCsrfValidator().saveToken(request, response, key, token);
		if (isGenEl) {
			JspWriter out = pageContext.getOut();
			String strCsrfInputHtml = genHtmlEl(token);
			try {
				out.println(strCsrfInputHtml);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return SKIP_BODY;
	}
	
	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
	
	private String getReqAttrsCsrfKey() {
		return CsrfProtectionProvider.getInstance().getReqAttrsKeyCsrfKey();
	}
	
	private String getReqAttrsKeyCsrfValue() {
		return CsrfProtectionProvider.getInstance().getReqAttrsKeyCsrfValue();
	}
	
	private String getReqParamsKeyCsrf() {
		return CsrfProtectionProvider.getInstance().getReqParamsKeyCsrf();
	}
	
	private String genRandomCsrfToken() {
		return CsrfProtectionProvider.getInstance().getCsrfValidator().generateToken();
	}
	
	private String genHtmlEl(String token) {
		String inputName = getReqParamsKeyCsrf();
		return String.format("<input type=\"hidden\" name=\"%s\" value=\"%s\"/>", inputName, token);
	}
	
}
