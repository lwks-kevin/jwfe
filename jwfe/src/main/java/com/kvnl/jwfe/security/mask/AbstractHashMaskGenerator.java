package com.kvnl.jwfe.security.mask;

public abstract class AbstractHashMaskGenerator extends AbstractBaseMaskGenerator {

	@Override
	public String mask(String strToMask) {
		String strGarble = garble(strToMask);
		if (strGarble != null) {
			String strHash = hash(strGarble);
			return strHash;
		}
		return null;
	};
	
	abstract public String hash(String strToHash);
	
	abstract public String garble(String strToGarble);

}
