package com.kvnl.jwfe.security.csrf.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CsrfTag {
	RequestMethod requestMethod();
	String urlPattern();
	String key();
	boolean once() default true;
}