package com.app.service;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_Exceptions.ResourceNotFoundException;
import com.app.dao.AddressDao;
import com.app.dao.UserEntityDao;
import com.app.dto.AddressDTO;
import com.app.entities.Address;
import com.app.entities.UserEntity;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao addDao;
	
	@Autowired
	private UserEntityDao userDao;
	
	@Autowired
	private ModelMapper mapper;
	
	
//	@Override
//	public AddressDTO getAddressDetails(Long userId) {
//		
//		return mapper.map(
//				addDao.findById(userId).orElseThrow(
//						() -> new ResourceNotFoundException("Invalid Emp  Id Or Address not yet assigned !!!!")),
//				AddressDTO.class);
//	}
	
	
	@Override
	public AddressDTO updateAddress(Long userId, @Valid AddressDTO dto) {
		Address addr= addDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Invalid user ID, Address not found!!"));
		mapper.map(dto, addr);
		return mapper.map(addDao.save(addr), AddressDTO.class);
		
	}

	@Override
	public AddressDTO asssignAddress(Long userId, @Valid AddressDTO dto) {
		UserEntity user= userDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Invalid user ID, User not found!!"));
		
		Address address = mapper.map(dto, Address.class);
		
		address.setUser(user);
		
		addDao.save(address);
		return mapper.map(address, AddressDTO.class);
	}

	

	
	
	
}
