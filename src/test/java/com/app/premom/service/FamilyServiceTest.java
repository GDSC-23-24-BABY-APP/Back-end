package com.app.premom.service;

import com.app.premom.dto.BabyFamilySaveDto;
import com.app.premom.entity.Roles;
import com.app.premom.entity.User;
import com.app.premom.repository.FamilyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest
public class FamilyServiceTest {
    @Autowired UserService userService;
    @Autowired FamilyService familyService;
    @Autowired FamilyRepository familyRepository;

    @Test
    public void 초대코드_가족_초대() throws Exception {
        //Given
        User mom = User.builder().familyType("mom")
                .username("mom1")
                .role(Roles.USER)
                .build();
        User dad = User.builder().familyType("dad")
                .username("dad1")
                .role(Roles.USER)
                .build();
        BabyFamilySaveDto dto = BabyFamilySaveDto.builder()
                .babyName("baby1")
                .babyNum(1)
                .babyBirthDate(LocalDateTime.now().toLocalDate())
                .build();

        //When
        String joinCode = familyService.save(mom, dto);
        System.out.println(joinCode);
        Long familyId = familyService.joinFamily(dad, joinCode);
        System.out.println(familyId);

        //Then
        Assertions.assertEquals(dad.getFamily(), familyRepository.findById(familyId).orElseThrow(()-> new IllegalArgumentException("해당 가족 정보를 찾을 수 없습니다.")));
    }
}
