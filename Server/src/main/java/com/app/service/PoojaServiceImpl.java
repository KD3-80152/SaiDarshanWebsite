package com.app.service;

import java.util.*;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.dao.PoojaDao;
import com.app.dto.*;
import com.app.entities.Pooja;


@Service
@Transactional
public class PoojaServiceImpl implements PoojaService{
	
	@Autowired
	private PoojaDao poojaDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public PoojaDTO addPoojaBooking(PoojaDTO pooja) {
		Pooja poojaEntity=  mapper.map(pooja, Pooja.class);
		Pooja persistentpooja = poojaDao.save(poojaEntity);
		return mapper.map(persistentpooja, PoojaDTO.class);
	}

	@Override
	public List<PoojaDTO> getAllPoojaBookingsByUserId(Long poojaId) {
		List<Pooja> poojaList = poojaDao.findByUserId(poojaId);
		return poojaList.stream().map(pooja -> mapper.map(pooja, PoojaDTO.class)).collect(Collectors.toList());
	}

	@Override
	public String deletePoojaBookingById(Long poojaId) {
		// TODO Auto-generated method stub
		return null;
	}

	
//	public String deletePoojaBookingById(Long poojaId) {
//		if (poojaDao.existsById(poojaId)) {
//			poojaDao.deleteById(poojaId);
//			return "Deleted pooja details....";
//		}
//		// => invalid Pooja id
//		throw new ResourceNotFoundException("Pooja  can't be deleted : Invalid Pooja Id!!!");
//		
//	}

	


}
