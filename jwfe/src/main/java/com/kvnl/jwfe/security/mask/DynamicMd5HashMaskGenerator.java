package com.kvnl.jwfe.security.mask;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DynamicMd5HashMaskGenerator extends AbstractHashMaskGenerator {
	
    public DynamicMd5HashMaskGenerator() {
    	
    }
    
    @Override
    public String mask(String strToMask) {
    	return super.mask(strToMask);
    }

	@Override
	public String hash(String strToHash) {
		return md5(strToHash);
	}

	// Sample
	@Override
	public String garble(String strToGarble) {
		if (strToGarble != null) {
			String perfix = genPerfix(strToGarble);
			String sufix = genSufix(strToGarble);
			String hashGarble = md5(perfix + strToGarble + sufix);
			return hashGarble;
		}
		return null;
	}
	
	// Sample
	private String genPerfix(String strToGenPerfix) {
		if (strToGenPerfix != null) {
    		if (!strToGenPerfix.isEmpty()) {
    			int v1 = strToGenPerfix.length();
    			int v2 = v1 % 10;
    			char[] v3 = strToGenPerfix.toCharArray();
    			return String.format("{%c%d%c%d%c%d}", v3[0], 0, v3[v2], v2, v3[v1-1], v1-1);
    		}
    	}
    	return null;
	}
	
	// Sample
	private String genSufix(String strToGenSufix) {
		if (strToGenSufix != null) {
    		if (!strToGenSufix.isEmpty()) {
    			int v1 = strToGenSufix.length();
    			int v2 = v1 % 10;
    			char[] v3 = strToGenSufix.toCharArray();
    			return String.format("{/%c%d%c%d%c%d}", v3[v1-1], v1-1, v3[v2], v2, v3[0], 0);
    		}
    	}
    	return null;
	}

	private String md5(String strToMd5) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] array = md.digest(strToMd5.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			String result = sb.toString();
			return result;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
