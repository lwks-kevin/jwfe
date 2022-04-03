package com.kvnl.jwfe.security.cycher;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESCypher {

    public String encrypt(String strToEncrypt, String keyStr, String ivStr) {
        if (strToEncrypt == null)
            return null;
        String result = null;
        try {
            result = encryptAES(strToEncrypt, genSecretKeySpec(keyStr), genIvParameterSpec(ivStr));
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String decrypt(String strToDecrypt, String keyStr, String ivStr) {
        if (strToDecrypt == null)
            return null;
        String result = null;
        try {
            result = decryptAES(strToDecrypt, genSecretKeySpec(keyStr), genIvParameterSpec(ivStr));
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private String encryptAES(String strToEncrypt, SecretKeySpec secretKey, IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
        return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
    }

    private String decryptAES(String strToDecrypt, SecretKeySpec secretKey, IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
        return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)),"UTF-8");
    }

    //產生金鑰
    private SecretKeySpec genSecretKeySpec(String secretKey) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] key = secretKey.getBytes("UTF-8");
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        key = sha.digest(key);
        key = Arrays.copyOf(key, 32);
        return new SecretKeySpec(key, "AES");
    }

    //產生偏移量
    private IvParameterSpec genIvParameterSpec(String ivStr) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] iv = ivStr.getBytes("UTF-8");
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        iv = sha.digest(iv);
        iv = Arrays.copyOf(iv, 16);
        return new IvParameterSpec(iv);
    }

}
