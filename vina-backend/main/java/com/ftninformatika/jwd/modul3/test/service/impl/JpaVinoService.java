package com.ftninformatika.jwd.modul3.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.test.model.Vino;
import com.ftninformatika.jwd.modul3.test.repository.VinoRepository;
import com.ftninformatika.jwd.modul3.test.service.VinoService;

@Service
public class JpaVinoService implements VinoService {
	
	@Autowired
	private VinoRepository vinoRepo;

	@Override
	public Vino findOne(Long id) {
		// TODO Auto-generated method stub
		return vinoRepo.findOneById(id);
	}

	@Override
	public Page<Vino> findAll(int pageNo) {
		// TODO Auto-generated method stub
		return vinoRepo.findAll(PageRequest.of(pageNo,4));
	}

	@Override
	public Vino save(Vino vino) {
		// TODO Auto-generated method stub
		return vinoRepo.save(vino);
	}

	@Override
	public Vino update(Vino vino) {
		// TODO Auto-generated method stub
		return vinoRepo.save(vino);
	}

	@Override
	public Vino delete(Long id) {
		Vino vino=findOne(id);
		if(vino!=null) {
			vino.getTip().getVina().remove(vino);
			vino.getVinarija().getVina().remove(vino);
			vinoRepo.delete(vino);
			return vino;
		}
		return null;
	}

	@Override
	public List<Vino> findByIdIn(List<Long> ids) {
		// TODO Auto-generated method stub
		return vinoRepo.findByIdIn(ids);
	}

	@Override
	public Page<Vino> search(String vinarija, String vino, int pageNo) {
		// TODO Auto-generated method stub
		return vinoRepo.search(vinarija, vino,PageRequest.of(pageNo,4) );
	}

	@Override
	public Vino naruciVino(Vino vino) {
		int naruceneFlase = 0;
		int sadasnjiBrojFlasa=vino.getBrojDostupnihFlasa()-naruceneFlase;
		vino.setBrojDostupnihFlasa(sadasnjiBrojFlasa);
		return vino;
		
	}

}
