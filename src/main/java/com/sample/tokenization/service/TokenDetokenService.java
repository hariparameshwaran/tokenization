package com.sample.tokenization.service;

import com.sample.tokenization.repository.VaultRepository;
import com.sample.tokenization.vault.Vault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Service
public class TokenDetokenService {

    @Autowired
    VaultRepository vaultRepository;

    private static final String secretKey = "ThisIsASecretKey";

    public  String tokenize(String originalData, String referenceId, String fieldName) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encryptedBytes = cipher.doFinal(originalData.getBytes());
            Vault vault = new Vault();
            vault.setSensitiveData(originalData);
            vault.setReferenceId(referenceId);
            vault.setFieldName(fieldName);
            String token = Base64.getEncoder().encodeToString(encryptedBytes);
            vault.setToken(token);
            vaultRepository.save(vault);
            return token;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public  String deTokenize(String token) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(token));
            return new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}

