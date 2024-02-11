package com.app.service;

import com.app.dto.UserDTO;

import javax.validation.Valid;

import com.app.dto.ApiResponse;
import com.app.dto.Signup;

public interface UserService {
//sign up
	Signup userRegistration(Signup reqDTO);


	UserDTO updateUser(Long userId, @Valid UserDTO dto);


	UserDTO getUserProfile(Long userId);


	ApiResponse deleteUserDetails(Long userId);


	ApiResponse changeUserPassword(Long userId, UserDTO dto);
}
