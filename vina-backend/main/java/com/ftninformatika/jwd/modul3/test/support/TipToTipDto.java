package com.ftninformatika.jwd.modul3.test.support;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.test.model.Tip;
import com.ftninformatika.jwd.modul3.test.model.Vino;
import com.ftninformatika.jwd.modul3.test.web.dto.TipDTO;

@Component
public class TipToTipDto implements Converter<Tip, TipDTO> {

	@Override
	public TipDTO convert(Tip tip) {
		TipDTO dto=new TipDTO();
		dto.setId(tip.getId());
		dto.setIme(tip.getIme());
		LinkedHashMap<Long, String>vinaMap=new LinkedHashMap<>();
		for(Vino vino:tip.getVina()) {
			vinaMap.put(vino.getId(), vino.getIme());
		}
		dto.setVina(vinaMap);
		return dto;
	}
	public List<TipDTO>convert(List<Tip>tipovi){
		 List<TipDTO>dtos=new ArrayList<>();
		 for(Tip tip:tipovi) {
			 dtos.add(convert(tip));
		 }
		return dtos;
	}

}
