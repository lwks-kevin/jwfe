package com.kvnl.jwfe.security.mask;

public interface MaskGenerator {

	String mask(String strToMask);
	
	String garble(String strToMask);
	
}
