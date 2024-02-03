package com.app.premom.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

;



@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ImageService {

    @Value("${spring.cloud.gcp.storage.bucket}") //application.u=yml에 써둔 bucket 이름
    private String bucketName;

//    public void saveBoardProfileImage(MultipartFile imageFile, long boardId) {
//        String originalName = imageFile.getOriginalFilename();
//        String ext = imageFile.getContentType();
//        String uuid = UUID.randomUUID().toString();
//        String fileName = uuid + "_" + originalName;
//        String uploadPath = UPLOAD_PATH + uuid;
//
//        // BUCKET_NAME = GCS에 등록된 버킷 이름
//        // 파일은 https://storage.googleapis.com/{버킷_이름}/{UUID}를 통해 조회할 수 있음
//        BlobInfo imageInfo = BlobInfo.newBuilder(BUCKET_NAME, uuid)
//                .setContentType(ext)
//                .build();
//
//        BlobInfo blobInfo = null;
//        try {
//            blobInfo = storage.create(
//                    imageInfo, imageFile.getInputStream()
//            );
//
//            ImageFileCreateDto dto = ImageFileCreateDto.builder()
//                    .originalName(originalName)
//                    .ext(ext)
//                    .uuid(uuid)
//                    .uploadPath(uploadPath)
//                    .fileName(fileName)
//                    .boardId(boardId)
//                    .build();
//
//            fileRepository.save(dto.toEntity(dto));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    //이미지 정보 수정
//    public void updateImageInfo(User user, ImageSaveRequestDto dto) throws IOException {
//
//        // !!! 이미지 업로드 관련 부분 !!!
//        String uuid = UUID.randomUUID().toString(); // Google Cloud Storage 에 저장될 파일 이름
//        String ext = dto.getImage().getContentType(); // 파일의 형식 ex) JPG
//
//        // Cloud에 이미지 업로드
//        BlobInfo blobInfo = storage.create(
//                BlobInfo.newBuilder(bucketName, uuid)
//                        .setContentType(ext)
//                        .build(),
//                dto.getImage().getInputStream()
//        );
//    }
}
