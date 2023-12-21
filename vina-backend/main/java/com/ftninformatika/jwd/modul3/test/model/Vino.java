
package com.ftninformatika.jwd.modul3.test.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vino {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable=false)
	private String ime;
	
	@Column
	private String opis;
	
	@Column(nullable=false,name="godina_proizvodnje")
	private int godinaProizvodnje;
	
	@Column(name="cena_flase")
	private double cenaFlase;
	
	@Column(name="broj_dostupnih_flasa")
	private int brojDostupnihFlasa;
	
	@ManyToOne
	private Tip tip;
	
	@ManyToOne
	private Vinarija vinarija;

	public Vino() {
		super();
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

	public Tip getTip() {
		return tip;
	}

	public void setTip(Tip tip) {
		this.tip = tip;
	}

	public Vinarija getVinarija() {
		return vinarija;
	}

	public void setVinarija(Vinarija vinarija) {
		this.vinarija = vinarija;
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
		Vino other = (Vino) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Vino [id=" + id + ", ime=" + ime + ", opis=" + opis + ", godinaProizvodnje=" + godinaProizvodnje
				+ ", cenaFlase=" + cenaFlase + ", brojDostupnihFlasa=" + brojDostupnihFlasa + ", tip=" + tip
				+ ", vinarija=" + vinarija + "]";
	}
	
	
	
	
}
