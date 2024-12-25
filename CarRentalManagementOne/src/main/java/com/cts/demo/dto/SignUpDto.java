package com.cts.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDto {

	private long id;
	
	@NotBlank(message="Username is required")
	@Size(min=3,max=20,message="Username must be between 3 and 20 characters")
	private String username;
	
	@Email(message="Email should be valid")
	private String email;
	
	@NotBlank(message="password is required")
	@Size(min=8,message="Password must be atleast 8 characters long")
	private String password;
	
}
