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


import com.ftninformatika.jwd.modul3.test.model.Vinarija;
import com.ftninformatika.jwd.modul3.test.service.VinarijaService;
import com.ftninformatika.jwd.modul3.test.support.VinarijaToVinarijaDto;
import com.ftninformatika.jwd.modul3.test.web.dto.VinarijaDTO;

@RestController
@RequestMapping(value = "/api/vinarije", produces = MediaType.APPLICATION_JSON_VALUE)
public class VinarijaController {
	
	@Autowired
	private VinarijaService vService;
	
	@Autowired
	private VinarijaToVinarijaDto toDto;
	
	@GetMapping
	public ResponseEntity<List<VinarijaDTO>>getAll(@RequestParam(value = "pageNo", defaultValue = "0") int pageNo){
		Page<Vinarija>page=vService.fidnAll(pageNo);
		
		HttpHeaders headers=new HttpHeaders();
		headers.add("Total-pages", Integer.toString(page.getTotalPages()));
		
		return new ResponseEntity<>(toDto.convert(page.getContent()),headers,HttpStatus.OK);
		
	}
	

}
