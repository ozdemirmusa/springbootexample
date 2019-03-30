package com.example.demo.model;

import org.hibernate.validator.constraints.NotEmpty;

public class Kisi {
	private int id;
	@NotEmpty(message="Adı Boş Bırakmayınız")
	private String ad;
	@NotEmpty(message="Soyadı Boş Bırakmayınız")
	private String soyad;
	@NotEmpty(message="Adresi Boş Bırakmayınız")
	private String adres;
	public Kisi() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Kisi(int id, String ad, String soyad, String adres) {
		super();
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
		this.adres = adres;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	

}
