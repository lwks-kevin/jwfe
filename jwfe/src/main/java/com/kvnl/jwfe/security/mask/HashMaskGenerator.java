package com.kvnl.jwfe.security.mask;

public interface HashMaskGenerator extends MaskGenerator {

	@Override
	default String mask(String strToMask) {
		String strGarble = garble(strToMask);
		if (strGarble != null) {
			String strHash = hash(strGarble);
			return strHash;
		}
		return null;
	};
	
	String hash(String strToHash);
	
	String garble(String strToGarble);

}
