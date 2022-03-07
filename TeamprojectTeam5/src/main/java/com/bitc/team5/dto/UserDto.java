package com.bitc.team5.dto;

import lombok.Data;

@Data
public class UserDto {
	private int seq;
	private String email;
	private String password;
	private int phone;
}
