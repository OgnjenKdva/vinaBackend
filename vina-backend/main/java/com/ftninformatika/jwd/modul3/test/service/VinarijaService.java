package com.ftninformatika.jwd.modul3.test.service;

import org.springframework.data.domain.Page;

import com.ftninformatika.jwd.modul3.test.model.Vinarija;

public interface VinarijaService {

	Page<Vinarija>fidnAll(int pageNo);
	
	Vinarija findOne(Long id);
}
