package com.example.shani.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.example.shani.payloads.UserDto;
import com.example.shani.services.userservice;
import com.example.shani.repositories.*;
import com.example.shani.entities.*;

public class UserServiceimpl implements userservice {
	private userrepo userRepo;

	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user =this.dtoToUser(userDto); 
		User savedUser = this.userRepo.save(user);
		return this.userTODto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto user, Integer userId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		user updateUser=this.userRepo.save(user);
		 User UserDto1=this.userTODto(updatedUser);
		return UserDto1;
	}
 
	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userrepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> user=this.userRepo.findAll();
		List<userDto> userDtos=user.stream().map(user -> this.userTODto(user)).collect(Collectors.toList());
	 	
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user =this.userRepo.findBy(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId))
        this.userRepo.delete(user);
	}   
	private User dtoToUser(UserDto userDto)
	{
		user user=new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setPassword(userDto.getpassword());
		return user;
	}
	public UserDto userTODto(User user)
	{
		userDto userDto=new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setAbout(user.getAbout());
		userDto.setPassword(user.getpassword());
		return userDto;
	}

}
