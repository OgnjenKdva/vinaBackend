package com.ftninformatika.jwd.modul3.test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.test.model.Vino;
import com.ftninformatika.jwd.modul3.test.web.dto.VinoDTO;

@Component
public class VinoToVinoDto implements Converter<Vino, VinoDTO>{
	
	@Autowired
	private TipToTipDto toTipDto;
	
	@Autowired
	private VinarijaToVinarijaDto toVinarijaDto;

	@Override
	public VinoDTO convert(Vino vino) {
		VinoDTO dto=new VinoDTO();
		dto.setId(vino.getId());
		dto.setCenaFlase(vino.getCenaFlase());
		dto.setBrojDostupnihFlasa(vino.getBrojDostupnihFlasa());
		dto.setGodinaProizvodnje(vino.getGodinaProizvodnje());
		dto.setIme(vino.getIme());
		dto.setOpis(vino.getOpis());
		dto.setTip(toTipDto.convert(vino.getTip()));
		dto.setVinarija(toVinarijaDto.convert(vino.getVinarija()));
		
		return dto;
	}
	public List<VinoDTO>convert(List<Vino>vina){
		List<VinoDTO>dtos=new ArrayList<>();
		for(Vino v:vina) {
			dtos.add(convert(v));
		}
		return dtos;
	}

}
