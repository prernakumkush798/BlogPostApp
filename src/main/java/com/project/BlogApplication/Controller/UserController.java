package com.project.BlogApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.BlogApplication.Dto.UserDto;
import com.project.BlogApplication.Service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("")
	public ResponseEntity<UserDto> add(@Valid @RequestBody UserDto userDto) {	
		UserDto addedUserDto= userService.add(userDto);
		return new ResponseEntity<UserDto>(addedUserDto, HttpStatus.CREATED);		
	}
	
	@GetMapping("")
	public ResponseEntity<List<UserDto>> getAllusers(){
		return new ResponseEntity<List<UserDto>>(userService.getAllUsers(), HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable int id){
		UserDto updatedUserDto=this.userService.update(userDto, id);
		return new ResponseEntity<UserDto>(updatedUserDto, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("id") int id){
		return new ResponseEntity<UserDto>(this.userService.getUserById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<UserDto> deleteUser(@PathVariable int id){
		UserDto userDto=this.userService.delete(id);
		return new ResponseEntity<UserDto>(userDto,HttpStatus.OK);		
	}
	

}
