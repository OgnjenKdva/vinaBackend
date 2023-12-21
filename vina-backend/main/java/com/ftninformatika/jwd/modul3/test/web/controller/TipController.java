package com.ftninformatika.jwd.modul3.test.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ftninformatika.jwd.modul3.test.model.Tip;
import com.ftninformatika.jwd.modul3.test.service.TipService;
import com.ftninformatika.jwd.modul3.test.support.TipToTipDto;
import com.ftninformatika.jwd.modul3.test.web.dto.TipDTO;

@RestController
@RequestMapping(value = "/api/tipovi", produces = MediaType.APPLICATION_JSON_VALUE)
public class TipController {
	
	@Autowired
	private TipService tService;
	
	@Autowired
	private TipToTipDto toDto;
	
	@GetMapping
	public ResponseEntity<List<TipDTO>>getAll(@RequestParam(value = "pageNo", defaultValue = "0") int pageNo){
		Page<Tip>page=tService.findAll(pageNo);
		
		HttpHeaders headers=new org.springframework.http.HttpHeaders();
		headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
		
		return new ResponseEntity<>(toDto.convert(page.getContent()),headers,HttpStatus.OK);
	}
	
	

}
