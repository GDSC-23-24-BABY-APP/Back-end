package com.app.premom.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JasyptConfigTest {

    @Test
    void jasypt() {
        String clientId = "618308615209-hc0oc3h414p8rhv1uou8lfmavmmod5b3.apps.googleusercontent.com";
        String clientSecret = "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";

        System.out.printf("%s -> %s", clientId, jasyptEncoding(clientId));
        System.out.printf("%s -> %s", clientSecret, jasyptEncoding(clientSecret));



    }

    public String jasyptEncoding(String value) {
        String key = "key";
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
        pbeEnc.setPassword(key);
        return pbeEnc.encrypt(value);
    }

}
