package com.kvnl.jwfe.security.authentication.model;

import java.util.List;

public interface SecurityAuthorization<T extends SecurityAuthorizationResource> {
	
	List<T> getAuthorizationResources();
	
	void setAuthorizationResources(List<T> authorizationResources);
	
}