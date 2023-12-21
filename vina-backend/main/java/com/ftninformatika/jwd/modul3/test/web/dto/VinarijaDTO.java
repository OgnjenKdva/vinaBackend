package com.ftninformatika.jwd.modul3.test.web.dto;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import javax.validation.constraints.Positive;

public class VinarijaDTO {
	
	@Positive(message = "Id mora biti pozitivan broj.")
    private Long id;
	
	private Map<Long,String>vina=new LinkedHashMap<>();
	
	private String ime;
	
	private int godinaOsnivanja;

	public VinarijaDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Map<Long, String> getVina() {
		return vina;
	}

	public void setVina(Map<Long, String> vina) {
		this.vina = vina;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public int getGodinaOsnivanja() {
		return godinaOsnivanja;
	}

	public void setGodinaOsnivanja(int godinaOsnivanja) {
		this.godinaOsnivanja = godinaOsnivanja;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VinarijaDTO other = (VinarijaDTO) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "VinarijaDTO [id=" + id + ", vina=" + vina + ", ime=" + ime + ", godinaOsnivanja=" + godinaOsnivanja
				+ ", getId()=" + getId() + ", getVina()=" + getVina() + ", getIme()=" + getIme()
				+ ", getGodinaOsnivanja()=" + getGodinaOsnivanja() + ", hashCode()=" + hashCode() + ", getClass()="
				+ getClass() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	

}
