package com.app.premom.service;

import com.app.premom.dto.UserInfoUpdateDto;
import com.app.premom.entity.User;
import com.app.premom.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long updateInfo(User user, UserInfoUpdateDto dto) {
        user.updateInfo(dto.getFamilyType(), dto.getWeight(), dto.getHeight(), dto.getBloodRhType(), dto.getBloodType());
        return user.getId();
    }

    public int getTerm(User user) {
        int day = user.getDay();
        return day % 7;
    }
}
