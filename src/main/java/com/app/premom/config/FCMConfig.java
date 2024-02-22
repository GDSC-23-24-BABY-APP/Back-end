package com.app.premom.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Configuration
public class FCMConfig {
    @Bean
    FirebaseMessaging firebaseMessaging() throws IOException {
        ClassPathResource resource = new ClassPathResource("firebase/파일이름.json");

        InputStream refreshToken = resource.getInputStream();

        FirebaseApp firebaseApp = null;
        List<FirebaseApp> firebaseAppList = FirebaseApp.getApps();

        if (firebaseAppList != null && !firebaseAppList.isEmpty()) {
            for (FirebaseApp app : firebaseAppList) {
                if (app.getName().equals(FirebaseApp.DEFAULT_APP_NAME)) {
                    firebaseApp = app;
                }
            }
        } else {
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(refreshToken))
                    .build();

            firebaseApp = FirebaseApp.initializeApp(options);
        }

        return FirebaseMessaging.getInstance(firebaseApp);
    }
}

//@Configuration
//public class FirebaseConfig {
//
//    private final Logger logger = LoggerFactory.getLogger(FirebaseConfig.class);
//    @PostConstruct
//    public void init() {
//        try {
//            FileInputStream serviceAccount = new FileInputStream("src/main/resources/config/key/tobemom-app-firebase-adminsdk-q2wwx-77662a5b81.json");
//            FirebaseOptions.Builder optionBuilder = FirebaseOptions.builder();
//            FirebaseOptions options = optionBuilder
//                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                    .build();
//            FirebaseApp.initializeApp(options);
//        } catch (FileNotFoundException e) {
//            logger.error("Firebase ServiceAccountKey FileNotFoundException" + e.getMessage());
//        } catch (IOException e) {
//            logger.error("FirebaseOptions IOException" + e.getMessage());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
