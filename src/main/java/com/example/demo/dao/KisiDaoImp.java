package com.example.demo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Kisi;

@Repository
public class KisiDaoImp implements KisiDao {
	List<Kisi> kisiler = new ArrayList<>();
	Map<Integer, Kisi> hashMap = new HashMap<Integer, Kisi>();

	@Override
	public void kaydet(Kisi kisi) {
		// TODO Auto-generated method stub

		kisi.setId(kisiler.size()+1);
		kisiler.add(kisi);

	}

	@Override
	public List<Kisi> liste() {
		// TODO Auto-generated method stub

		return kisiler;
	}

	@Override
	public void sil(int id) {
		// TODO Auto-generated method stub
		// kisiler.remove(kisiler.get(id));
		for (int i = 0; i < kisiler.size(); i++) {
			if (kisiler.get(i).getId() == id) {
				kisiler.remove(i);
			}
		}
	}

	@Override
	public void guncelle(Kisi kisi) {
		// TODO Auto-generated method stub
		//kisiler.set(kisi.getId(), kisi);
		for (int i = 0; i < kisiler.size(); i++) {
			if (kisiler.get(i).getId() == kisi.getId()) {
				kisiler.set(i, kisi);
			}
		}

	}

	@Override
	public Kisi getir(int id) {
		// TODO Auto-generated method stub
		Kisi k=new Kisi();
		for (int i = 0; i < kisiler.size(); i++) {
			if (kisiler.get(i).getId() == id) {
				k=kisiler.get(i);
			}
		}
		return k;
	}

}
