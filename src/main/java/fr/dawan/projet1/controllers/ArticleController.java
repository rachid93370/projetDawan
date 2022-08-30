package fr.dawan.projet1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.dawan.projet1.repositories.ArticleRepository;

@Controller
@RequestMapping("/projet1/articles")
public class ArticleController {

	@Autowired
	ArticleRepository articleRepository;
	
	// Retourne tous les articles
	@GetMapping
	public String getAllArticle(Model model) {
		model.addAttribute("article", articleRepository.findAll());
		return "articles";
	}
	
	// Retourne un article
	@GetMapping(value = "/{id}")
	public String getArticleById(Model model, @PathVariable long id) {
		model.addAttribute("article", articleRepository.ArticleById(id));
		return "articles";
	}

}
