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
	
	private String csrfReqParamsKey;
	
	private CsrfValidator csrfValidator;
	
	private CsrfAnnotationClassReflector csrfAnnotationClassReflector;
	
	public CsrfProtectionProvider() {
		csrfReqParamsKey = CsrfConstant.REQ_PARAMS_KEY_CSRF_TOKEN;
		csrfValidator = new SessionCsrfValidator();
		csrfAnnotationClassReflector = new CsrfAnnotationClassReflector();
	}
	
	public String getCsrfReqParamsKey() {
		return csrfReqParamsKey;
	}
	
	public void setCsrfReqParamsKey(String csrfReqParamsKey) {
		this.csrfReqParamsKey = csrfReqParamsKey;
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
