package net.javaguides.spring_react_application_backend.service;

import net.javaguides.spring_react_application_backend.dto.LoginDto;
import net.javaguides.spring_react_application_backend.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);
    String login(LoginDto loginDto);
}
