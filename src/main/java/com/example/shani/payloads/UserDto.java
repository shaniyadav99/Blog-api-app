package com.example.shani.payloads;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Setter
@Getter

public class UserDto {
	private int id;
	private String name;
	private String email;
	private String password;
	private String about;

}
