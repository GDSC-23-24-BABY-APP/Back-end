package com.app.premom.service;

import com.app.premom.dto.BabyFamilySaveDto;
import com.app.premom.entity.BabyFamily;
import com.app.premom.entity.User;
import com.app.premom.repository.FamilyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class FamilyService {

    private final FamilyRepository familyRepository;

    /**
     * familyType이 mom인 사용자가 가족(아기) 정보 생성
     * @param user
     * @param dto
     * @return
     */
    @Transactional
    public String save(User user, BabyFamilySaveDto dto) {
        if (user.getFamilyType() == "mom") {
            //user.updateFamily(dto.toEntity());
            user.updateFamily(familyRepository.save(dto.toEntity()));
            return user.getFamily().getJoinCode();
        }

        else {
            return "mom 인 user만 아기 정보를 생성할 수 있습니다.";
        }
    }

    @Transactional
    // 회원의 가족 추가
    public Long joinFamily(User user, String code) {
        if(familyRepository.findByJoinCode(code).isPresent()) {
            BabyFamily family = familyRepository.findByJoinCode(code).orElseThrow(() -> new IllegalArgumentException("해당 family가 존재하지 않습니다."));
            user.updateFamily(family);
            return family.getId();
        }
        else return -1L;
    }
}
