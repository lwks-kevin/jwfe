package com.kvnl.jwfe.security.authentication;

import com.kvnl.jwfe.security.authentication.configuration.AuthenticationConfiguration;
import com.kvnl.jwfe.security.authentication.repository.AuthenticationRepository;
import com.kvnl.jwfe.security.authentication.service.AuthenticationService;
import com.kvnl.jwfe.security.authentication.service.AuthorizationService;

@SuppressWarnings("rawtypes")
public class AuthenticationManager implements AuthenticationManagerProvider, AuthenticationManagerContext {

	private static AuthenticationManager instance;

	public static AuthenticationManager getInstance() {
		if (instance == null) {
			synchronized (AuthenticationManager.class) {
				instance = new AuthenticationManager();
			}
		}
		return instance;
	}

	private AuthenticationConfiguration authenticationConfiguration;
	private AuthenticationRepository authenticationRepository;
	private AuthenticationService authenticationService;
	private AuthorizationService authorizationService;
	
	public AuthenticationManager() {
		
	}
	
	@Override
	public AuthenticationConfiguration getAuthenticationConfiguration() {
		return this.authenticationConfiguration;
	}

	@Override
	public void setAuthenticationConfiguration(AuthenticationConfiguration authenticationConfiguration) {
		this.authenticationConfiguration = authenticationConfiguration;
	}

	@Override
	public AuthenticationRepository getAuthenticationRepository() {
		return this.authenticationRepository;
	}

	@Override
	public void setAuthenticationRepository(AuthenticationRepository authenticationRepository) {
		this.authenticationRepository = authenticationRepository;
	}

	@Override
	public AuthenticationService getAuthenticationService() {
		return this.authenticationService;
	}

	@Override
	public void setAuthenticationService(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	@Override
	public AuthorizationService getAuthorizationService() {
		return this.authorizationService;
	}

	@Override
	public void setAuthorizationService(AuthorizationService authorizationService) {
		this.authorizationService = authorizationService;
	}

	@Override
	public AuthenticationManagerContext getContext() {
		return this;
	}

}
