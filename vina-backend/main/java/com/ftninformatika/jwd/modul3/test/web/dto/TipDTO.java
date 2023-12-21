package com.ftninformatika.jwd.modul3.test.web.dto;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import javax.validation.constraints.Positive;

public class TipDTO {
	
	private Map<Long,String>vina=new LinkedHashMap<>();
	
	 @Positive(message = "Id mora biti pozitivan broj.")
	 private Long id;
	 
	 private String ime;

	public TipDTO() {
		super();
	}

	public Map<Long, String> getVina() {
		return vina;
	}

	public void setVina(Map<Long, String> vina) {
		this.vina = vina;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
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
		TipDTO other = (TipDTO) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "TipDTO [vina=" + vina + ", id=" + id + ", ime=" + ime + "]";
	}
	 
	 

}
