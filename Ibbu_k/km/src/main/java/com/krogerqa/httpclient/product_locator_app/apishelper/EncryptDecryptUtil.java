package com.krogerqa.httpclient.product_locator_app.apishelper;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Class to encrypt and decrypt the string
 * @author SYL9159
 */
public class EncryptDecryptUtil {

    /**
     *
     * @param strClearText
     * @return
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public static String encrypt(String strClearText) throws InvalidKeyException, NoSuchAlgorithmException,
            NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        return encrypt(strClearText, "automation");
    }

    /**
     *
     * @param strClearText
     * @param strKey
     * @return
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public static String encrypt(String strClearText, String strKey) throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec skeyspec = new SecretKeySpec(strKey.getBytes(), "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(1, skeyspec);
        byte[] encrypted = cipher.doFinal(strClearText.getBytes());
        String encoded = Base64.getEncoder().encodeToString(encrypted);
        return encoded;
    }

    /**
     *
     * @param strEncrypted
     * @return
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public static String decrypt(String strEncrypted) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        //logger.info("DECRYPTING PASSWORD");
        return decrypt(strEncrypted, "automation");
    }

    /**
     *
     * @param strEncrypted
     * @param strKey
     * @return
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public static String decrypt(String strEncrypted, String strKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        String strData = "";
        SecretKeySpec skeyspec = new SecretKeySpec(strKey.getBytes(), "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(2, skeyspec);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(strEncrypted));
        strData = new String(decrypted);
        return strData;
    }

    public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {

        EncryptDecryptUtil encryptDecryptUtil = new EncryptDecryptUtil();
        System.out.println("encrypt " + encryptDecryptUtil.encrypt(""));
    }
}
