package com.kvnl.jwfe.security.csrf;

import com.kvnl.jwfe.security.csrf.annotation.CsrfAnnotationClassReflector;
import com.kvnl.jwfe.security.csrf.base.CsrfConstant;
import com.kvnl.jwfe.security.csrf.validator.CsrfValidator;
import com.kvnl.jwfe.security.csrf.validator.SessionCsrfValidator;

public class CsrfProtectionProvider {

	private static CsrfProtectionProvider instance;
	
	public static CsrfProtectionProvider getInstance() {
		if (instance == null) {
			synchronized (CsrfProtectionProvider.class) {
				instance = new CsrfProtectionProvider();
			}
		}
		return instance;
	}
	
	private String reqParamsKeyCsrf;
	
	private String reqAttrsKeyCsrfKey;
	
	private String reqAttrsKeyCsrfValue;
	
	private CsrfValidator csrfValidator;
	
	private CsrfAnnotationClassReflector csrfAnnotationClassReflector;
	
	public CsrfProtectionProvider() {
		reqParamsKeyCsrf = CsrfConstant.REQ_PARAMS_CSRF_TOKEN;
		reqAttrsKeyCsrfKey = CsrfConstant.REQ_ATTRS_KEY_CSRF_TOKEN_KEY;
		reqAttrsKeyCsrfValue = CsrfConstant.REQ_ATTRS_KEY_CSRF_TOKEN_VALUE;
		csrfValidator = new SessionCsrfValidator();
		csrfAnnotationClassReflector = new CsrfAnnotationClassReflector();
	}
	
	public String getReqParamsKeyCsrf() {
		return reqParamsKeyCsrf;
	}

	public void setReqParamsKeyCsrf(String reqParamsKeyCsrf) {
		this.reqParamsKeyCsrf = reqParamsKeyCsrf;
	}

	public String getReqAttrsKeyCsrfKey() {
		return reqAttrsKeyCsrfKey;
	}

	public void setReqAttrsKeyCsrfKey(String reqAttrsKeyCsrfKey) {
		this.reqAttrsKeyCsrfKey = reqAttrsKeyCsrfKey;
	}

	public String getReqAttrsKeyCsrfValue() {
		return reqAttrsKeyCsrfValue;
	}

	public void setReqAttrsKeyCsrfValue(String reqAttrsKeyCsrfValue) {
		this.reqAttrsKeyCsrfValue = reqAttrsKeyCsrfValue;
	}

	public CsrfValidator getCsrfValidator() {
		return csrfValidator;
	}
	
	public void setCsrfValidator(CsrfValidator csrfValidator) {
		this.csrfValidator = csrfValidator;
	}

	public CsrfAnnotationClassReflector getCsrfAnnotationClassReflector() {
		return csrfAnnotationClassReflector;
	}
	
}
