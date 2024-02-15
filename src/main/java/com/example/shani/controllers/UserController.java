package com.example.shani.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.shani.payloads.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@Requestmapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping("/")
	
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
	{
		 UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	}
	

}
