package fr.dawan.projet1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.dawan.projet1.forms.UserForm;
import fr.dawan.projet1.repositories.ArticleRepository;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	ArticleRepository articleRepository;
	
//	@GetMapping
//	public String accueil2() {
//		return "home";
//	}
	
	@GetMapping("/home")
	public String accueil() {
		return "home";
	}

//	@GetMapping("/signIn")
//	public String signIn(@ModelAttribute("formUser") UserForm userForm) {
//		return "addUser";
//	}
	
	// Retourne tous les articles
	@GetMapping("/articles")
	public String getAllArticles(Model model) {
		model.addAttribute("article", articleRepository.findAll());
		return "listArticles";
	}

	// Retourne un article
	@GetMapping(value = "/articles/{id}")
	public String getArticleById(Model model, @PathVariable long id) {
		model.addAttribute("article", articleRepository.ArticleById(id));
		return "listArticles";
	}
	
	@GetMapping(value = "/categories/{idCategorie}")
	public String listArticles(Model model, @PathVariable long idCategorie) {
		model.addAttribute("article", articleRepository.ArticleByIdCategorie(idCategorie));
		return "listArticles";
	}
	
}
