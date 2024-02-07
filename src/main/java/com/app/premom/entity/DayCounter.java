package com.app.premom.entity;

import com.app.premom.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@EnableScheduling
public class DayCounter {

    private final UserRepository userRepository;

    //매일 day 값이 1씩 증가하도록 함
    @Scheduled(cron = "0 0 0 * * *") // 매일 0시에 실행
    public void increaseDay() {
        // User 엔티티의 day 속성 값을 증가시키는 로직
        userRepository.incrementDayForAllUsers();
    }
}

