package com.app.premom.controller;

import com.app.premom.dto.ImageSaveRequestDto;
import com.app.premom.entity.User;
import com.app.premom.service.ImageService;
import com.app.premom.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;

import java.io.IOException;

@RequiredArgsConstructor
@Controller
public class ImageController {

    private final ImageService imageService;
    private final LoginService loginService;

    @PatchMapping("")
    public ResponseEntity<Void> updateImageInfo(Authentication auth, ImageSaveRequestDto dto) throws IOException {
        User user = loginService.getLoginUserByLoginId(auth.getName());
        imageService.updateImageInfo(user, dto);
    }
}
