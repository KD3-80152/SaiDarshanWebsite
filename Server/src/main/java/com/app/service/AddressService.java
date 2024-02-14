package com.app.service;

import javax.validation.Valid;

import com.app.dto.AddressDTO;

public interface AddressService {

	AddressDTO updateAddress(Long userId, @Valid AddressDTO dto);

	AddressDTO asssignAddress(Long userId, @Valid AddressDTO dto);

	AddressDTO getAddressDetails(Long userId);
}
