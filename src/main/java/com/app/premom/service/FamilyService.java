package com.app.premom.service;

import com.app.premom.entity.BabyFamily;
import com.app.premom.entity.User;
import com.app.premom.repository.FamilyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class FamilyService {

    private final FamilyRepository familyRepository;

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
