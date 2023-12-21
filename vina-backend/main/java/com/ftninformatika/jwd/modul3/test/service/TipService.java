package com.ftninformatika.jwd.modul3.test.service;

import org.springframework.data.domain.Page;

import com.ftninformatika.jwd.modul3.test.model.Tip;

public interface TipService {
	
	Page<Tip>findAll(int pageNo);
	
	Tip findOne(Long id);

}
