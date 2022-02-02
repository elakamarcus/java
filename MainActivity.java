package com.example.mala0377_aes;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import android.os.Build;
import android.os.Bundle;
import java.util.Base64;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView showNonce;
    TextView showKey;
    TextView showCipher;
    TextView customClearText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String message = "Introduction to Computer Security";
        byte[] ciphertext = null;

        byte[] key = new byte[16];
        new Random().nextBytes(key);
        String encodedKey = byteToString(key);
        showKey = findViewById(R.id.default_keybyte);
        showKey.setText(encodedKey);

        byte[] nonce = new byte[12];
        new Random().nextBytes(nonce);
        String encodedNonce = byteToString(nonce);
        showNonce = findViewById(R.id.default_noncebyte);
        showNonce.setText(encodedNonce);

        AESAlgorithm aesAlgorithm = new AESAlgorithm();
        aesAlgorithm.AESAlgorithm(message, key, nonce);
        try {
            ciphertext = aesAlgorithm.encrypt(message);
            String stringCipherText = new String(ciphertext);
            Log.d("encrypt",stringCipherText);
            String encodedCipher = byteToString(ciphertext);
            showCipher = findViewById(R.id.default_cipherbyte);
            showCipher.setText(encodedCipher);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String plainText = aesAlgorithm.decrypt(ciphertext);
        Log.d("decrypt", plainText);
        customClearText = findViewById(R.id.customClearText);
        customClearText.setText(plainText);
    }

    public String byteToString(byte[] msg){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return Base64.getEncoder().encodeToString(msg);
        }
        return "unable to translate byte array";
    }
}