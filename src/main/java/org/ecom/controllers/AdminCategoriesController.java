package org.ecom.controllers;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import org.ecom.entities.Categorie;
import org.ecom.metier.IAdminCategoriesMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/adminCat")
public class AdminCategoriesController {
	@Autowired
	private IAdminCategoriesMetier metier;
	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("categorie",new Categorie());
		model.addAttribute("categories",metier.listeCatgories());
		return "categories";
		}
	@RequestMapping("/saveCat")
	public String saveCat(@Valid Categorie c,BindingResult bindingReslt,
			Model model,MultipartFile file) throws IOException {
		if (bindingReslt.hasErrors()) {
			model.addAttribute("categories",metier.listeCatgories());
			return("categoris");
			
		}
		if (!file.isEmpty()) {
			BufferedImage bi=ImageIO.read(file.getInputStream());
			c.setPhoto(file.getBytes());
			c.setNomPhoto(file.getOriginalFilename());
			
		}
		metier.ajouterCategorie(c);
		model.addAttribute("categorie",new Categorie());
		model.addAttribute("categories",metier.listeCatgories());
				return "categories";
		
		
	}
	

}
