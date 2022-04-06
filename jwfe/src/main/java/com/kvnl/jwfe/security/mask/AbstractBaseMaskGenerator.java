package com.kvnl.jwfe.security.mask;

public abstract class AbstractBaseMaskGenerator {

	abstract public String mask(String strToMask);
	
	abstract public String garble(String strToMask);
}
