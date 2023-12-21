package com.ftninformatika.jwd.modul3.test.support;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.test.model.Vinarija;
import com.ftninformatika.jwd.modul3.test.model.Vino;
import com.ftninformatika.jwd.modul3.test.web.dto.VinarijaDTO;

@Component
public class VinarijaToVinarijaDto implements Converter<Vinarija, VinarijaDTO> {

	@Override
	public VinarijaDTO convert(Vinarija vinarija) {
		VinarijaDTO dto=new VinarijaDTO();
		dto.setId(vinarija.getId());
		dto.setGodinaOsnivanja(vinarija.getGodinaOsnivanja());
		dto.setIme(vinarija.getIme());
		LinkedHashMap<Long, String>vinaMap=new LinkedHashMap<>();
		for(Vino vino:vinarija.getVina()) {
			vinaMap.put(vino.getId(), vino.getIme());
		}
		dto.setVina(vinaMap);
		return dto;
	}
	public List<VinarijaDTO>convert(List<Vinarija>vinarije){
		List<VinarijaDTO>dtos=new ArrayList<>();
		for(Vinarija vinarija:vinarije) {
			dtos.add(convert(vinarija));
		}
		return dtos;
	}

}
