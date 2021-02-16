package org.ecom.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.ecom.entities.Categorie;
import org.ecom.metier.IAdminCategoriesMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/adminCat")
public class AdminCategoriesController implements HandlerExceptionResolver{
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
			return("categories");
			
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
	//methode permet le controller d'envoyer la photo
	@RequestMapping(value ="photoCat",produces=MediaType.IMAGE_JPEG_VALUE) 
	@ResponseBody
	public byte[] photoCat(Long idCat) throws IOException{
		Categorie c=metier.getCategorie(idCat);
		return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto()));
		
	}
	//exception
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("exception",ex.getMessage());
		mv.setViewName("categories");
		return mv;
	}

}
