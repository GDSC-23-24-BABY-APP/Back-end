package com.app.premom.service;

import com.app.premom.dto.LoginRequestDto;

public interface AuthService {

    public String login(LoginRequestDto dto) throws Exception;

}
