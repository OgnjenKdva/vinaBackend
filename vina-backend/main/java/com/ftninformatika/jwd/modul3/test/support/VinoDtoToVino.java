package com.ftninformatika.jwd.modul3.test.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.test.model.Vino;
import com.ftninformatika.jwd.modul3.test.service.TipService;
import com.ftninformatika.jwd.modul3.test.service.VinarijaService;
import com.ftninformatika.jwd.modul3.test.service.VinoService;
import com.ftninformatika.jwd.modul3.test.web.dto.VinoDTO;

@Component
public class VinoDtoToVino implements Converter<VinoDTO,Vino> {
	
	@Autowired
	private VinoService vinoService;
	
	@Autowired
	private TipService tipService;
	
	@Autowired
	private VinarijaService vinarijaService;
	

	@Override
	public Vino convert(VinoDTO dto) {
		Vino vino;
		
		if(dto.getId()==null) {
			vino=new Vino();
		}else {
			vino=vinoService.findOne(dto.getId());
		}
		if(vino!=null) {
			vino.setBrojDostupnihFlasa(dto.getBrojDostupnihFlasa());
			vino.setCenaFlase(dto.getCenaFlase());
			vino.setGodinaProizvodnje(dto.getGodinaProizvodnje());
			vino.setIme(dto.getIme());
			vino.setOpis(dto.getOpis());
			vino.setTip(tipService.findOne(dto.getTip().getId()));
			vino.setVinarija(vinarijaService.findOne(dto.getVinarija().getId()));
		}
		return vino;
	}

}
