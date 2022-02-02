package com.example.mala0377_aes;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESAlgorithm {
    private SecretKey secretKey;
    IvParameterSpec ivParameterSpec;
    private byte[] plaintext;

    /**
     * Create a aesalgorithm object
     * @param message to be encrypted
     * @param nonce random bytes
     */
    public void AESAlgorithm(String message, byte[] secretkey, byte[] nonce){
        plaintext = message.getBytes();
        secretKey = new SecretKeySpec(secretkey, "AES");
        ivParameterSpec = new IvParameterSpec(nonce);
    }

    /**
     * encrypt a message using AES algorithm
     * @return returns ciphertext in bytes
     */
    public byte[] encrypt(String stringPlaintext) throws Exception
    {
        byte[] bytePlaintext = stringPlaintext.getBytes();
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
        return cipher.doFinal(bytePlaintext);
    }

    public String decrypt(byte[] cipherText)
    {
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
            byte[] decryptedText = cipher.doFinal(cipherText);
            return new String(decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
