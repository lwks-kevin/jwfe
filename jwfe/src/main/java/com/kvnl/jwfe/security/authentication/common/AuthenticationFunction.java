package com.kvnl.jwfe.security.authentication.common;

import com.kvnl.jwfe.security.authentication.exception.AuthenticationException;

@FunctionalInterface
public interface AuthenticationFunction<T,R> {
	R apply(T t) throws AuthenticationException;
}
