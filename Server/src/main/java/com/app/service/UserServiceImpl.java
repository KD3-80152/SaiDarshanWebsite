package com.app.service;

import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_Exceptions.ResourceNotFoundException;
import com.app.dao.AddressDao;
import com.app.dao.UserEntityDao;
import com.app.dto.ApiResponse;
import com.app.dto.Signup;
import com.app.dto.UserDTO;
import com.app.entities.Address;
import com.app.entities.UserEntity;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserEntityDao userDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private AddressDao addDao;

	//SIGNUP
	@Override
	public Signup userRegistration(Signup reqDTO) {
		
		UserEntity user=mapper.map(reqDTO, UserEntity.class);
		user.setPassword(encoder.encode(user.getPassword()));//pwd : encrypted using SHA
		return mapper.map(userDao.save(user), Signup.class);
	}

	
	//GET PROFILE
	@Override
	public UserDTO getUserProfile(Long userId) {
		UserEntity curUser= userDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Invalid user ID, User not found!!"));
		
		return mapper.map(curUser, UserDTO.class) ;
	}
			
		
		
		
		
	//UPDATE PROFILE
	@Override
	public UserDTO updateUser(Long userId, @Valid UserDTO dto) {
		
		UserEntity curUser= userDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Invalid user ID, User not found!!"));
		mapper.map(dto, curUser);
		return mapper.map(userDao.save(curUser), UserDTO.class);
	}


	//DELETE USER
	@Override
	public ApiResponse deleteUserDetails(Long userId) {
		
		Optional<Address> optAddr = addDao.findById(userId);
		if(optAddr.isPresent())
			addDao.delete(optAddr.get());
		
		UserEntity user= userDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Invalid id , can't delete"));
		
		userDao.delete(user);
		
		
		return new ApiResponse("User with ID " +user.getId() +" deleted.");
	}


	

	//CHANGE PASSWORD
	
	@Override
	public ApiResponse changeUserPassword(Long userId, UserDTO dto) {
		
		if(dto.getNewPassword().equals(dto.getConfirmNewPassword()))
		{
			UserEntity curUser=userDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Invalid user ID, User not found!!"));
			String encryptedPassword = encoder.encode(dto.getConfirmNewPassword());
			curUser.setPassword(encryptedPassword);
		}
		else
		{
			throw new ResourceNotFoundException("Passwords don't match");
		}
		
		return new ApiResponse("Password changed successfully");
	}
	






	
	
	

	
	
}
