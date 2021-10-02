package com.sip.ams.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sip.ams.entities.Etudiant;

@Controller
public class EtudiantController {
	
	List<Etudiant> etudiants = new ArrayList<>();
	
	{
		
		etudiants.add(new Etudiant("1", "amine", "amine@gmail.com"));
		etudiants.add(new Etudiant("2", "rami", "rami@gmail.com"));
		etudiants.add(new Etudiant("3", "patrick", "patrick@gmail.com"));
	}
	
	@RequestMapping("/home")
	public String message(Model model)
	{
		System.out.println("Bienvenue au BootCamp");
		String formation = "fullstack 100% Spring boot";
		String lieu ="Sesame";
		model.addAttribute("training", formation);
		model.addAttribute("location", lieu);
		return "info";
	}

//	@RequestMapping("/products")
//	public String listProducts (Model model)
//	{
//		List <String> products = new ArrayList<>();
//		products.add("PC");
//		products.add("Smartphone");
//		products.add("Tablette");
//		
//		model.addAttribute("mesProduits",products);
//		
//		return "products";
//	}
	
	
	@RequestMapping("/products")
	public ModelAndView listProducts ()
	{
		ModelAndView mv = new ModelAndView();
		
		List <String> products = new ArrayList<>();
		products.add("PC");
		products.add("Smartphone");
		products.add("Tablette");
		
		mv.addObject("mesProduits", products);
		mv.setViewName("products");
		
		return mv;
		
	}
	
	@RequestMapping("/students")
	public ModelAndView listStudients ()
	{
		ModelAndView mv = new ModelAndView();
		
//		List <Etudiant> students = new ArrayList<>();
//
//		students.add(new Etudiant("1","X","x@gmail.com"));
//		students.add(new Etudiant("2","Y","y@gmail.com"));
//		students.add(new Etudiant("3","Z","z@gmail.com"));
//		
		
		mv.addObject("students", etudiants);
		mv.setViewName("students");
		
		return mv;
		
	}
	
	// @GetMapping("/add")
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addStudentForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addStudent");
		return mv;

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addStudent(@RequestParam("id") String id, @RequestParam("nomEtudiant") String nom,
			@RequestParam("email") String email) {
		// ModelAndView mv = new ModelAndView();
		// mv.setViewName("listStudents");
		// return mv;
		Etudiant e = new Etudiant(id, nom, email);
		etudiants.add(e);
		return "redirect:students";

	}
	
}
