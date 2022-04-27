package com.kvnl.jwfe.security.authentication;

public interface AuthenticationManagerProvider<T extends AuthenticationManagerContext> {

	T getContext();
	
}
