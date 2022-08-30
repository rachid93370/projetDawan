package fr.dawan.projet1.controllers;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.dawan.projet1.entities.Utilisateur;
import fr.dawan.projet1.forms.UtilisateurForm;
import fr.dawan.projet1.repositories.UtilisateurRepository;

@Controller
@RequestMapping("/projet1/utilisateurs")
public class UtilisateurController {

	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	// Retourne tous les utilisateurs
	@GetMapping
	public String getAllUtilisateur(Model model) {
		model.addAttribute("utilisateur", utilisateurRepository.findAll());
		return "utilisateurs";
	}
	
	// Retourne un utilisateur
	@GetMapping(value = "/{id}")
	public String getUtilisateurById(Model model, @PathVariable long id){
		model.addAttribute("utilisateur", utilisateurRepository.UtilisateurById(id));
		return "utilisateurs";
	}

	@GetMapping(value = "/delete/{id}")
	public String deleteUtilisateur(@PathVariable long id) {
			utilisateurRepository.deleteById(id);
			return "redirect:/projet1/utilisateurs";
	}
	
    @GetMapping("/add")
    public String ajoutUtilisateur(@ModelAttribute("formuser") UtilisateurForm userForm) {
        return "ajoutUtilisateurs";
    }
	
	// Ajout d'un utilisateur
    @PostMapping("/add")
    public ModelAndView ajoutUtilisateur(@Valid @ModelAttribute("formuser")  UtilisateurForm userForm, BindingResult results) {
//        new UserValidator().validate(userForm, results);
       ModelAndView mdv=new ModelAndView();
        if(results.hasErrors()) {
            mdv.setViewName("ajoutUtilisateurs");
            mdv.addObject("formuser", userForm);
            mdv.addObject("errors",results);
        }else {
            Utilisateur u = new Utilisateur(userForm.getNom(), userForm.getPrenom(), userForm.getEmail(), userForm.getMotPasse(), userForm.getTelephone(), LocalDate.now(), userForm.getDateNaissance());
            utilisateurRepository.saveAndFlush(u);
            mdv.setViewName("redirect:/projet1/utilisateurs");
        }
        return mdv;    
    }
	
	
	

}
