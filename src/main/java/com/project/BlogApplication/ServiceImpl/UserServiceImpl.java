package com.project.BlogApplication.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.BlogApplication.Dto.UserDto;
import com.project.BlogApplication.Entity.User;
import com.project.BlogApplication.Exception.ResourceNotFoundException;
import com.project.BlogApplication.Repository.UserRepository;
import com.project.BlogApplication.Service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	UserRepository repository;
	ModelMapper modelMapper;

	@Transactional
	public UserDto add(UserDto userdto) {
		Optional<User> userexists=this.repository.findByEmail(userdto.getEmail());
		if(userexists.isPresent()) {
			throw new IllegalArgumentException("User with this email already exists.");
		}
		User user = this.userDtoToUser(userdto);
		User savedUser = this.repository.save(user);
		return this.userToUserDto(savedUser);
	}

	
	@Transactional
	public UserDto update(UserDto userDto, int id) {
		// TODO Auto-generated method stub
		User user = this.repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User Id", id));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		User savedUser = this.repository.save(user);
		return this.userToUserDto(savedUser);

	}

	
	@Transactional
	public UserDto getUserById(int id) {
		// TODO Auto-generated method stub
		User user = this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
		return this.userToUserDto(user);
	}

	
	@Transactional
	public UserDto delete(int id) {
		// TODO Auto-generated method stub
		User user = this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
		this.repository.delete(user);
		return this.userToUserDto(user);
	}

	
	@Transactional
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = this.repository.findAll();
		List<UserDto> userdto = users.stream().map((item) -> (this.userToUserDto(item))).collect(Collectors.toList());
		return userdto;
	}

	public User userDtoToUser(UserDto userdto) {
		User user = this.modelMapper.map(userdto,User.class);
			return user;
	}

	public UserDto userToUserDto(User user) {
		UserDto userDto = this.modelMapper.map(user,UserDto.class);
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setPassword(user.getPassword());
//		userDto.setEmail(user.getEmail());
		return userDto;
	}

}
