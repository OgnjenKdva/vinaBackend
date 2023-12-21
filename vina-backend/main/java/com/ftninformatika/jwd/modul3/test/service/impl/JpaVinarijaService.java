package com.ftninformatika.jwd.modul3.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.test.model.Vinarija;
import com.ftninformatika.jwd.modul3.test.model.Vino;
import com.ftninformatika.jwd.modul3.test.repository.VinarijaRepository;
import com.ftninformatika.jwd.modul3.test.service.VinarijaService;
import com.ftninformatika.jwd.modul3.test.service.VinoService;

@Service
public class JpaVinarijaService implements VinarijaService {
	
	@Autowired
	private VinarijaRepository vinarijaRepo;

	@Override
	public Page<Vinarija> fidnAll(int pageNo) {
		// TODO Auto-generated method stub
		return vinarijaRepo.findAll(PageRequest.of(pageNo,10));
	}

	@Override
	public Vinarija findOne(Long id) {
		// TODO Auto-generated method stub
		return vinarijaRepo.findOneById(id);
	}
	

}
