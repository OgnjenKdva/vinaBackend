package com.ftninformatika.jwd.modul3.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.test.model.Tip;
import com.ftninformatika.jwd.modul3.test.repository.TipRepository;
import com.ftninformatika.jwd.modul3.test.service.TipService;

@Service
public class JpaTipService implements TipService {
	
	@Autowired
	private TipRepository tRepo;
	
	@Override
	public Page<Tip> findAll(int pageNo) {
		// TODO Auto-generated method stub
		return tRepo.findAll(PageRequest.of(pageNo,5));
	}

	@Override
	public Tip findOne(Long id) {
		// TODO Auto-generated method stub
		return tRepo.findOneById(id);
	}

}
