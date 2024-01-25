//package com.app.premom.service;
//
//import com.app.premom.dto.CustomUserInfoDto;
//import com.app.premom.dto.LoginRequestDto;
//import com.app.premom.entity.User;
//import com.app.premom.jwt.JwtUtils;
//import com.app.premom.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@RequiredArgsConstructor
//@Transactional(readOnly = true)
//public class AuthServiceImpl implements AuthService{
//
//    private final JwtUtils jwtUtil;
//    private final UserRepository userRepository;
//    private final PasswordEncoder encoder;
//    private final ModelMapper modelMapper;
//
//    @Override
//    @Transactional
//    public String login(LoginRequestDto dto) throws Exception{
//        String email = dto.getEmail();
//        String password = dto.getPassword();
//        User user = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("가입되지 않은 Email 입니다."));
//        if(user == null) {
//            throw new UsernameNotFoundException("이메일이 존재하지 않습니다.");
//        }
//
//        // 암호화된 password를 디코딩한 값과 입력한 패스워드 값이 다르면 null 반환
//        if(!encoder.matches(password, user.getPassword())) {
//            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
//        }
//
//        CustomUserInfoDto info = modelMapper.map(user, CustomUserInfoDto.class);
//
//        String accessToken = jwtUtil.createAccessToken(info);
//        return accessToken;
//    }
//}
