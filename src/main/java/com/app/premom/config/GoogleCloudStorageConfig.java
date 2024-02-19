package com.app.premom.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@Slf4j
@Configuration
public class GoogleCloudStorageConfig {

//    @Value("${spring.cloud.gcp.storage.project-id}")
//    private String projectId;

    @Bean
    public Storage storage() throws IOException {

        ClassPathResource resource = new ClassPathResource("/tobemom-app-d42ca99c2757.json");
        GoogleCredentials credentials = GoogleCredentials.fromStream(resource.getInputStream());
        //String projectId = projectId_;
        String projectId = "tobemom-app";
        log.info("클라우드 정보" + resource.getFilename());
        return StorageOptions.newBuilder()
                .setProjectId(projectId)
                .setCredentials(credentials)
                .build()
                .getService();
    }
}
