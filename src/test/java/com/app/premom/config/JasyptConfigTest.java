package com.app.premom.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JasyptConfigTest {

    @Test
    void jasypt() {

//        System.out.printf("%s -> %s", clientId, jasyptEncoding(clientId));
//        System.out.printf("%s -> %s", clientSecret, jasyptEncoding(clientSecret));



    }

    public String jasyptEncoding(String value) {
        String key = "key";
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
        pbeEnc.setPassword(key);
        return pbeEnc.encrypt(value);
    }

}
