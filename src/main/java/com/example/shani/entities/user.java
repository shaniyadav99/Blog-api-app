package com.example.shani.entities;

import jakarta.persistence.Entity;

import jakarta.persistence.Table;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name="users")
@NoArgsConstructor
@Getter
@Setter

public class user {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int id;
	@Column(name="user_name", nullable=false , length=100)
	private String name;
	private String email;
	private String password;
	private String about;

}
