package com.cts.demo.service;

import com.cts.demo.dto.SignInDto;
import com.cts.demo.dto.SignUpDto;

public interface AuthService {
	String login(SignInDto signInDto);
	String register(SignUpDto signUpDto);
}
