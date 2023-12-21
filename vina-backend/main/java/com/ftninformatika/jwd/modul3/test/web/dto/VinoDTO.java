package com.ftninformatika.jwd.modul3.test.web.dto;

import java.util.Objects;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class VinoDTO {
	
	@Positive(message = "Id mora biti pozitivan broj.")
    private Long id;
	
	private String ime;
//	@Size
//	
//	@Max(value=120)
	private String opis;
	
	@Positive
	private int godinaProizvodnje;
	
	@Positive
	private double cenaFlase;
	
	private int brojDostupnihFlasa;
	
	private TipDTO tip;
	
	private VinarijaDTO vinarija;

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

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}

	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}

	public double getCenaFlase() {
		return cenaFlase;
	}

	public void setCenaFlase(double cenaFlase) {
		this.cenaFlase = cenaFlase;
	}

	public int getBrojDostupnihFlasa() {
		return brojDostupnihFlasa;
	}

	public void setBrojDostupnihFlasa(int brojDostupnihFlasa) {
		this.brojDostupnihFlasa = brojDostupnihFlasa;
	}

	public TipDTO getTip() {
		return tip;
	}

	public void setTip(TipDTO tip) {
		this.tip = tip;
	}

	public VinarijaDTO getVinarija() {
		return vinarija;
	}

	public void setVinarija(VinarijaDTO vinarija) {
		this.vinarija = vinarija;
	}

	public VinoDTO() {
		super();
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
		VinoDTO other = (VinoDTO) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "VinoDTO [id=" + id + ", ime=" + ime + ", opis=" + opis + ", godinaProizvodnje=" + godinaProizvodnje
				+ ", cenaFlase=" + cenaFlase + ", brojDostupnihFlasa=" + brojDostupnihFlasa + ", tip=" + tip
				+ ", vinarija=" + vinarija + "]";
	}
	
	
	
	
	
}
