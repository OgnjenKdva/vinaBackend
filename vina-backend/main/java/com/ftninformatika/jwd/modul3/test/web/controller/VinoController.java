package com.ftninformatika.jwd.modul3.test.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ftninformatika.jwd.modul3.test.model.Vino;
import com.ftninformatika.jwd.modul3.test.service.VinoService;
import com.ftninformatika.jwd.modul3.test.support.VinoDtoToVino;
import com.ftninformatika.jwd.modul3.test.support.VinoToVinoDto;
import com.ftninformatika.jwd.modul3.test.web.dto.VinoDTO;

@RestController
@RequestMapping(value = "/api/vina", produces = MediaType.APPLICATION_JSON_VALUE)
public class VinoController {
	
	@Autowired
	private VinoToVinoDto toDto;
	
	@Autowired
	private VinoDtoToVino toVino;
	
	@Autowired
	private VinoService vService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VinoDTO>create(@Valid @RequestBody VinoDTO vinoDTO){
		Vino vino=toVino.convert(vinoDTO);
		
		if(vino.getTip()==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if(vino.getVinarija()==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Vino sacuvanoVino=vService.save(vino);
		
		return new ResponseEntity<>(toDto.convert(sacuvanoVino),HttpStatus.CREATED);
		}
	@PutMapping(value="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VinoDTO>update(@PathVariable Long id,@Valid @RequestBody VinoDTO vinoDTO){
		
		if(!id.equals(vinoDTO.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Vino vino=toVino.convert(vinoDTO);
		if(vino.getTip()==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if(vino.getVinarija()==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Vino sacuvanoVino=vService.update(vino);
		
		return new ResponseEntity<>(toDto.convert(sacuvanoVino),HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		Vino obrisanoVino=vService.delete(id);
		if(obrisanoVino==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<VinoDTO>getOne(@PathVariable Long id){
		Vino vino=vService.findOne(id);
		
		if(vino!=null) {
			return new ResponseEntity<>(toDto.convert(vino),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
	@GetMapping 
	public ResponseEntity<List<VinoDTO>>getAll(
			@RequestParam(required=false) String vinarija,
			@RequestParam(required=false) String vino,
			@RequestParam(value = "pageNo", defaultValue = "0") int pageNo){
		Page<Vino>page;
		page=vService.search(vinarija, vino, pageNo);
		HttpHeaders headers=new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
		
		return new ResponseEntity<>(toDto.convert(page.getContent()),headers,HttpStatus.OK);
	}
	@PutMapping(value="/{id}")
	public ResponseEntity<VinoDTO>naruci(@PathVariable Long id ,@RequestParam(required=false)Integer naruceneFlase){
	
		Vino vino=vService.findOne(id);
		int noviBrojFlasa=vino.getBrojDostupnihFlasa()-naruceneFlase;
		vino.setBrojDostupnihFlasa(noviBrojFlasa);
		System.out.println("Broj flasa je"+naruceneFlase);
		return new ResponseEntity<>(toDto.convert(vino),HttpStatus.OK);
		
	}
			
}

