package com.app.premom.service;

import com.app.premom.dto.UserInfoUpdateDto;
import com.app.premom.entity.User;
import com.app.premom.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserService {
    private final UserRepository userRepository;

    public Long updateInfo(User user, UserInfoUpdateDto dto) {
        user.updateInfo(dto.getFamilyType(), dto.getWeight(), dto.getHeight(), dto.getBloodRhType(), dto.getBloodType());
        return user.getId();
    }

}
