package com.kvnl.jwfe.security.csrf.annotation;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashSet;

public class CsrfAnnotationClassReflector {

	public HashSet<CsrfTag> reflectAnnotationClass(Class ...classArgs) {
		HashSet<CsrfTag> hashSetCsrfTags = new HashSet<CsrfTag>();
		for (Class clazz : classArgs) {
			Method[] aryMethod = clazz.getDeclaredMethods();
			for (Method method : aryMethod) {
				CsrfTag csrfTag = method.getAnnotation(CsrfTag.class);
				if (csrfTag != null) {
					hashSetCsrfTags.add(csrfTag);
				}
			}
		}
		return hashSetCsrfTags;
	}
	
}
