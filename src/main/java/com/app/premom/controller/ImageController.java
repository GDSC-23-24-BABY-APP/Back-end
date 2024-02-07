package com.app.premom.controller;

import com.app.premom.dto.ImageSaveRequestDto;
import com.app.premom.entity.User;
import com.app.premom.repository.UserRepository;
import com.app.premom.service.ImageService;
import com.app.premom.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    private final UserRepository userRepository;

    @PatchMapping("/image")
    public ResponseEntity<Void> updateImageInfo(Authentication auth, ImageSaveRequestDto dto) throws IOException {
        User user = loginService.getLoginUserByLoginId(auth.getName());
        imageService.updateImageInfo(user, dto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/image/test")
    public ResponseEntity<Void> updateImageInfo1(ImageSaveRequestDto dto) throws IOException {
        //User user = loginService.getLoginUserByLoginId(auth.getName());
        User user = userRepository.findById(1L).orElseThrow();

        imageService.updateImageInfo(user, dto);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
