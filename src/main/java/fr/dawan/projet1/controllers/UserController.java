package fr.dawan.projet1.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.dawan.projet1.entities.Adresse;
import fr.dawan.projet1.entities.Utilisateur;
import fr.dawan.projet1.forms.MotdePasseValidation;
import fr.dawan.projet1.forms.UserForm;
import fr.dawan.projet1.repositories.UtilisateurRepository;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	
	
	// Infos utilisateur
	
	@GetMapping("/infos")
	public String accueil() {
		return "userInfos";
	}
	
	// Modification utilisateur
	
	@GetMapping("/update")
	public String updateUser(@ModelAttribute("formUser") UserForm userForm) {
		return "updateUser";
	}

}
