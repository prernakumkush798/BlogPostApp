package com.project.BlogApplication.Service;

import java.util.List;

import com.project.BlogApplication.Dto.UserDto;

public interface UserService {
	
	UserDto add(UserDto userDto);
	UserDto update(UserDto userDto,int id);
	UserDto delete(int id);
	List<UserDto> getAllUsers();
	UserDto getUserById(int id);

}
