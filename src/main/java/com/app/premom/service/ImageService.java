package com.app.premom.service;

import com.app.premom.dto.ImageSaveRequestDto;
import com.app.premom.entity.User;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ImageService {

    @Value("${spring.cloud.gcp.storage.bucket}") //application.u=yml에 써둔 bucket 이름
    private String bucketName;
    @Value("${spring.cloud.gcp.storage.project-id}")
    private String projectId;

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();


    //이미지 정보 수정
    public void updateImageInfo(User user, ImageSaveRequestDto dto) throws IOException {

        // !!! 이미지 업로드 관련 부분 !!!
        String uuid = UUID.randomUUID().toString(); // Google Cloud Storage 에 저장될 파일 이름
        String ext = dto.getImage().getContentType(); // 파일의 형식 ex) JPG

        // Cloud에 이미지 업로드
        BlobId blobId = BlobId.of(bucketName, uuid);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
                .setContentType(ext)
                .build();
        try (WriteChannel writer = storage.writer(blobInfo)) {
            byte[] imageData = dto.getImage().getBytes(); // 이미지 데이터를 byte 배열로 읽어옵니다.
            writer.write(ByteBuffer.wrap(imageData));
        } catch (Exception ex) {
            // 예외 처리 코드
            ex.printStackTrace();
        }
        // DB에 반영
        user.updateProfileImage(uuid);
    }
}
