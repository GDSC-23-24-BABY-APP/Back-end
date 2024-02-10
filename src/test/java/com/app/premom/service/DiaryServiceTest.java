package com.app.premom.service;

import com.app.premom.dto.DiarySaveRequestDto;
import com.app.premom.entity.User;
import com.app.premom.repository.DiaryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class DiaryServiceTest {
    @Autowired UserService userService;
    @Autowired DiaryService diaryService;
    @Autowired DiaryRepository diaryRepository;

    @Test
    public void 다이어리_생성() throws Exception {
        //Given
        User user = User.builder().username("TestUser1").build();

        DiarySaveRequestDto diarySaveRequestDto = DiarySaveRequestDto.builder()
                .title("다이어리1")
                .contents("내용1")
                .emoticon(1)
                .build();

        //When
        Long saveId = diaryService.save(user, diarySaveRequestDto);

        //Then
        Assertions.assertEquals(user, diaryRepository.findById(saveId).get().getAuthor());
    }
}
