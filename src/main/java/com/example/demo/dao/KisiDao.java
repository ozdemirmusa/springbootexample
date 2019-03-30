package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Kisi;

public interface KisiDao {
	public void kaydet(Kisi kisi);
	public List<Kisi> liste();
	public void  sil(int id);
	public void guncelle(Kisi kisi);
	public Kisi getir(int id);

}
