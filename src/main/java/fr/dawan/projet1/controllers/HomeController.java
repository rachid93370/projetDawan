package fr.dawan.projet1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.dawan.projet1.forms.UserForm;

@Controller
@RequestMapping("/")
public class HomeController {
	
//	@GetMapping
//	public String accueil2() {
//		return "home";
//	}
	
	@GetMapping("/home")
	public String accueil() {
		return "home";
	}

	@GetMapping("/signIn")
	public String signIn(@ModelAttribute("formUser") UserForm userForm) {
		return "addUser";
	}
	
}
