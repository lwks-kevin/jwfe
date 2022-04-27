package com.kvnl.jwfe.security.authentication.configuration;

import java.util.List;

import com.kvnl.jwfe.security.authentication.model.SecurityAuthorization;
import com.kvnl.jwfe.security.authentication.model.SecurityAuthorizationResource;
import com.kvnl.jwfe.security.authentication.model.SecurityPrincipal;

public interface AuthenticationConfiguration<X extends SecurityPrincipal<Y>, Y extends SecurityAuthorization<Z>, Z extends SecurityAuthorizationResource> {

	String getSessionSecurityPrincipalKey();

	void setSessionSecurityPrincipalKey(String newSessionKeySecurityPrincipal);
	
	String getSessionSecurityAuthorizationKey();

	void setSessionSecurityAuthorizationKey(String newSessionKeySecurityAuthorization);
	
	String getSignInIdentityKey();

	void setSignInIdentityKey(String identityKey);

	String getSignInCertificationKey();

	void setSignInCertificationKey(String certificationKey);
		
	List<Z> getAllowlist();
	
	void addAllowlistItem(Z ... allowItems);	
	
}
