package com.app.premom.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageSaveRequestDto {

    private String nickname;
    private MultipartFile image; // 업로드할 이미지
}
