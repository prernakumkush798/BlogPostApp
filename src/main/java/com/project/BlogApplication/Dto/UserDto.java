package com.project.BlogApplication.Dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserDto {
	
	int id;
	
	@NotEmpty(message = "Name is mandatory")
	@Size(min=4,max=20)
	String name;
	
	@Email
	String email;
	
	@NotEmpty
	String password;
	

}
