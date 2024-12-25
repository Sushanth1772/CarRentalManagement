package com.cts.demo.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PassEncrypt {
public static void main(String[] args) {
	
	PasswordEncoder encoder = new BCryptPasswordEncoder();
	System.out.println(encoder.encode("gagan@123"));
	
}
}
