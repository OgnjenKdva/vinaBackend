package com.ftninformatika.jwd.modul3.test.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ftninformatika.jwd.modul3.test.model.Vino;

public interface VinoService {
	
	Vino findOne(Long id);
	
	Page<Vino>findAll(int pageNo);
	
	Vino save(Vino vino);
	
	Vino update(Vino vino);
	
	Vino delete(Long id);
	
	List<Vino>findByIdIn(List<Long>ids);
	
	Page<Vino>search(String vinarija,String vino, int pageNo);
	
	Vino naruciVino(Vino vino);

}
