package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Address;

@Repository
public interface AddressDao extends JpaRepository<Address, Long>{

     Address findByUserId(Long userId);
	
}
