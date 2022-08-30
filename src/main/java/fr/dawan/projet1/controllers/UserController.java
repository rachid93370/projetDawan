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
@RequestMapping("/user")
public class UserController {

	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	// Ajout d'un utilisateur
	@GetMapping("/signIn")
	public String ajoutUtilisateur(@ModelAttribute("formUser") UserForm userForm) {
		return "addUser";
	}

	
	@PostMapping("/signIn")
	public ModelAndView ajoutUtilisateur(@Validated @ModelAttribute("formUser") UserForm userForm,
			BindingResult results) {
        	new MotdePasseValidation().validate(userForm, results);
		ModelAndView mdv = new ModelAndView();
		if (results.hasErrors()) {
			mdv.setViewName("addUser");
			mdv.addObject("formUser", userForm);
			mdv.addObject("errors", results);
		} else {
			Adresse a = new Adresse(userForm.getNumero(), userForm.getRue(), userForm.getCodePostal(), userForm.getVille());
			List<Adresse> listAdresse = new ArrayList<>();
			listAdresse.add(a);
			Utilisateur u = new Utilisateur(userForm.getNom(), userForm.getPrenom(), userForm.getEmail(),
					userForm.getMotPasse(), userForm.getTelephone(), LocalDate.now(), userForm.getDateNaissance());
			u.setAdresseFacturation(listAdresse);
			u.setAdresseLivraison(listAdresse);			
			utilisateurRepository.saveAndFlush(u);
			mdv.setViewName("redirect:/home/");
		}
		return mdv;
	}

	@GetMapping("/infos")
	public String accueil() {
		return "userInfos";
	}

	@GetMapping("/update")
	public String updateUser(@ModelAttribute("formUser") UserForm userForm) {
		return "updateUser";
	}

	// Retourne tous les utilisateurs
	@GetMapping
	public String getAllUtilisateur(Model model) {
		model.addAttribute("users", utilisateurRepository.findAll());
		return "listUsersInfos";
	}

}
