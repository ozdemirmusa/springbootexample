package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.KisiDaoImp;
import com.example.demo.model.Kisi;

@Controller
public class KisiController {
	@Autowired
	private KisiDaoImp KisiDaoImp;
	
	@GetMapping("/")
	public String index(Model model) {

		List<Kisi> kisiList = KisiDaoImp.liste();
		model.addAttribute("yKisi", new Kisi());
		model.addAttribute("kisiler", kisiList);
		return "index";
	}

	@GetMapping("/liste")
	public String liste(Model model) {

		List<Kisi> kisiList = KisiDaoImp.liste();
		model.addAttribute("yKisi", new Kisi());
		model.addAttribute("kisiler", kisiList);
		return "index";
	}

	@PostMapping(value = "/ekle")
	public String ekle(@Valid @ModelAttribute("yKisi") Kisi kisi, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("kisiler", KisiDaoImp.liste());
			return "index";
		}
		KisiDaoImp.kaydet(kisi);
		return "redirect:/liste";
	}

	@GetMapping(value = "/sil")
	public String sil(@RequestParam("kisiId") int id) {

		KisiDaoImp.sil(id);

		return "redirect:/liste";
	}

	@GetMapping(value = "/duzelt")
	public String duzelt(@RequestParam("kisiId") int id, Model model) {

		model.addAttribute("yKisi", KisiDaoImp.getir(id));
		model.addAttribute("kisiler", KisiDaoImp.liste());
		model.addAttribute("guncelle", "1");

		return "index";
	}

	@RequestMapping(value = "/guncelle", method = RequestMethod.POST)
	public String guncelle(@Valid @ModelAttribute("yKisi") Kisi kisi, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("update", "update");
			model.addAttribute("kisiler", KisiDaoImp.liste());
			return "index";
		}
		
		KisiDaoImp.guncelle(kisi);
		return "redirect:/liste";
	}

}
