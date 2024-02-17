package com.app.premom.service;

import com.app.premom.dto.CalCheckListResultDto;
import com.app.premom.dto.CheckListResponseDto;
import com.app.premom.entity.CheckList;
import com.app.premom.entity.CheckListResult;
import com.app.premom.entity.Question;
import com.app.premom.entity.User;
import com.app.premom.repository.CheckListRepository;
import com.app.premom.repository.CheckListResultRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CheckListService {

    private final CheckListRepository checkListRepository;
    private final CheckListResultRepository checkListResultRepository;

    public CheckListResponseDto findByNum(int num) {
        CheckList checkList = checkListRepository.findByNum(num).orElseThrow(()-> new IllegalArgumentException("해당 num인 체크리스트가 존재하지 않습니다."));
        return new CheckListResponseDto(checkList);
    }

    // 체크리스트 생성, 저장 -- 직접 해야 함
    public Long saveCheckList() {
        Question question1 = Question.builder()
                .num(1)
                .content("There is vaginal bleeding.")
                .risk(10).build();
//        Question question1 = Question.builder()
//                .num(1)
//                .content("There is vaginal bleeding.")
//                .risk(10).build();
        /**
         * There is vaginal bleeding.
         *
         * Having difficulty sleeping at night.
         *
         * Fingerprints do not easily appear when pressing the skin.
         *
         * I have a headache.
         *
         * I'm short of breath.
         *
         * My eyes feel dry.
         *
         * There is discomfort in the back of my neck.
         *
         * I have symptoms of bloating.
         **/
        CheckList checkList1 = CheckList.createCheckList(0, question1);

        return checkListRepository.save(checkList1).getId();
    }

    // 체크리스트 계산 결과 정보 조회
    public int getResultInfo(CalCheckListResultDto dto) {
        CheckList checkList = checkListRepository.findById(dto.getCheckListId()).orElseThrow(()-> new IllegalArgumentException("해당 id 의 체크리스트가 존재하지 않슴니다."));

        int result = 0;
        for (int i = 0; i < checkList.getQuestions().size(); i++) {
            int risk = checkList.getQuestions().get(i).getRisk();
            int isChecked = dto.getAnswerList().get(i);
            result += risk * isChecked;
        }

        // 체크리스트 num 값이 0이면 초기(유산 질문), 1이면 중기, 2이면 후기(사산 질문)


        // result 값이 몇 이상인지에 따라 사산 위험(0), 유산 위험(1), 건강함(2) 중 하나로 결과 보냄.
        if (result >= 90) {
            //...
        }
        else if (result >= 75) {
            //...
        }
        else {
            //...
        }

        return 0;

    }

    public Long saveCheckListResult(User user, int result) {
        CheckListResult checkListResult = CheckListResult.createCheckListResult(user, result);
        return checkListResultRepository.save(checkListResult).getId();
    }

    public int findResultByUserAndDate(User user, LocalDateTime dateTime) {
        return checkListResultRepository.findByUserAndCreatedAt(user, dateTime).orElseThrow(() -> new IllegalArgumentException("해당 유저와 작성시간의 체크리스트 결과 정보가 존재하지 않습니다.")).getResult();
    }

//    @Transactional
//    public List<CheckListResponseDto> getPosts() {
//        return checkListRepository.findAllByOrderModifiedAtDesc().stream().map(CheckListResponseDto::new).toList();
//    }
//
//    @Transactional
//    public Long save(User user, CheckListSaveRequestDto dto) {
//        CheckList checkList = dto.toEntity(user);
//        CheckList savedCheckList = checkListRepository.save(checkList);
//        return savedCheckList.getId();
//    }
}