package com.kvnl.jwfe.security.authentication.common;

import com.kvnl.jwfe.security.authentication.exception.AuthorizationException;

@FunctionalInterface
public interface AuthorizationFunction<T,R> {
	R apply(T t) throws AuthorizationException;
}
