package fr.dawan.projet1.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.dawan.projet1.entities.Adresse;
import fr.dawan.projet1.entities.Authority;
import fr.dawan.projet1.entities.Utilisateur;
import fr.dawan.projet1.entities.VerificationToken;
import fr.dawan.projet1.forms.LoginForm;
import fr.dawan.projet1.forms.MotdePasseValidation;
import fr.dawan.projet1.forms.UserForm;
import fr.dawan.projet1.repositories.ArticleRepository;
import fr.dawan.projet1.repositories.UtilisateurRepository;
import fr.dawan.projet1.repositories.VerificationTokenRepository;
import fr.dawan.projet1.services.MailService;

@Controller
//@RequestMapping("/user")
public class LoginController {
	
	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	VerificationTokenRepository verifTokenRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/login")
    public String getLogin() {
        return "login";
    }
	
	// Ajoute un utilisateur
	
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
						userForm.getTelephone(), passwordEncoder.encode(userForm.getMotPasse()), LocalDate.now(), userForm.getDateNaissance());
				u.setAdresseFacturation(listAdresse);
				u.setAdresseLivraison(listAdresse);	
				u.getAuthorities().add(new Authority("USER"));
				utilisateurRepository.saveAndFlush(u);
				VerificationToken token=new VerificationToken(u);
				verifTokenRepository.saveAndFlush(token);
				mailService.sendMail(u.getEmail(),
										"nopreplay@dawan.com",
										"Mail de confirmation Spring Boot project",
										genContentEmail(token));
				mdv.setViewName("redirect:/home/");
			}
			return mdv;
		}
		
		private String genContentEmail(VerificationToken token) {
			StringBuffer sb=new StringBuffer("<html><body><h1>Confirmation d'email SpringBootProject</h1><p>");
			sb.append("<div><a href='localhost:8080/springbootProject/verifymail/");
			sb.append(token.getToken());
			sb.append("'>Cliquer sur ce lien pour confirmer votre email</a></div>");
			sb.append("<p>le lien est valable 24 heures</p></body></html>");
			return sb.toString();
		}
		
		@GetMapping("/verifymail/{token}")
		public String verifcationEmailUser(@PathVariable String token) {
			VerificationToken t=verifTokenRepository.findByToken(token);
			if(t!=null && LocalDateTime.now().compareTo(t.getDateExpiration())<=0) {
				Utilisateur u= t.getUtilisateur();
				u.setEnabled(true);
				utilisateurRepository.saveAndFlush(u);
				verifTokenRepository.delete(t);
			}
			return "redirect:/login";
		}
		
}
