package fr.dawan.projet1.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.dawan.projet1.entities.Article;
import fr.dawan.projet1.entities.Categorie;
import fr.dawan.projet1.entities.Marque;
import fr.dawan.projet1.forms.ArticleForm;
import fr.dawan.projet1.repositories.ArticleRepository;
import fr.dawan.projet1.repositories.CategorieRepository;
import fr.dawan.projet1.repositories.MarqueRepository;
import fr.dawan.projet1.repositories.UtilisateurRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	ArticleRepository articleRepository;

	@Autowired
	CategorieRepository categorieRepository;

	@Autowired
	MarqueRepository marqueRepository;

	@Autowired
	UtilisateurRepository utilisateurRepository;

	// Retourne tous les utilisateurs
	@GetMapping("/users")
	public String getAllUtilisateurs(Model model) {
		model.addAttribute("users", utilisateurRepository.findAll());
		return "listUsersInfos";
	}
	
	//Retourne un utilisateur
	@GetMapping(value = "/users/{id}")
	public String getUtilisateurById(Model model, @PathVariable long id) {
		model.addAttribute("users", utilisateurRepository.UtilisateurById(id));
		return "listUsersInfos";
	}

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
	
	// Ajoute un article

	@GetMapping("/addArticle")
	public String addArticle(@ModelAttribute("formArticle") ArticleForm userForm) {
		return "addArticle";
	}

	@PostMapping("/addArticle")
	public ModelAndView ajoutUtilisateur(@Valid @ModelAttribute("formArticle") ArticleForm articleForm,
			BindingResult results) {
		ModelAndView mdv = new ModelAndView();
		if (results.hasErrors()) {
			mdv.setViewName("addArticle");
			mdv.addObject("formArticle", articleForm);
			mdv.addObject("errors", results);
		} else {
			Categorie categorie = categorieRepository.findByNom(articleForm.getCategorie());
			Marque marque = marqueRepository.findByNom(articleForm.getMarque());
			Article a = new Article(articleForm.getNom(), articleForm.getDescription(), articleForm.getPrix(),
					categorie, marque, articleForm.getQuantite());
			articleRepository.saveAndFlush(a);
			mdv.setViewName("redirect:/admin/articles");
		}
		return mdv;
	}
	
	//
	@GetMapping("/updateArticle")
	public String updateArticle(@ModelAttribute("formArticle") ArticleForm userForm) {
		return "updateArticle";
	}

}