package com.app.premom.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@Configuration
public class GoogleCloudStorageConfig {

    @Value("${spring.cloud.gcp.storage.project-id}")
    private String projectId;

    @Bean
    public Storage storage() throws IOException {

        ClassPathResource resource = new ClassPathResource("tobemom-app-77a7ec138a73.json");
        GoogleCredentials credentials = GoogleCredentials.fromStream(resource.getInputStream());
        //String projectId = projectId_;
        return StorageOptions.newBuilder()
                .setProjectId("tobemom-app")
                .setCredentials(credentials)
                .build()
                .getService();
    }
}
