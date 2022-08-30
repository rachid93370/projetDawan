package fr.dawan.projet1.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	ArticleRepository articleRepository;
	
	@Autowired
	CategorieRepository categorieRepository;
	
	@Autowired
	MarqueRepository marqueRepository;
	
	@GetMapping("/articles")
	public String listArticles() {
		return "listArticles";
	}
	
	@GetMapping("/users")
	public String listUsers() {
		return "listUsersInfos";
	}

	 @GetMapping("/addArticle")
	    public String addArticle(@ModelAttribute("formArticle") ArticleForm userForm) {
	        return "addArticle";
	    }
	 @GetMapping("/updateArticle")
	    public String updateArticle(@ModelAttribute("formArticle") ArticleForm userForm) {
	        return "updateArticle";
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
				Article a = new Article(articleForm.getNom(), articleForm.getDescription(), articleForm.getPrix(), categorie, marque, articleForm.getQuantite());		
				articleRepository.saveAndFlush(a);
				mdv.setViewName("redirect:/admin/articles");
			}
			return mdv;
		}

}