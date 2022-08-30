package fr.dawan.projet1.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyErrorController implements ErrorController {

	@GetMapping("/pageError")
	public String errorPage(HttpServletRequest request, Model model) {
		int codeErreur = (int) request.getAttribute("javax.servlet.error.status_code");
		switch (codeErreur) {
		case 404:
			model.addAttribute("msgErreur", "La page est introuvable");
			break;
		case 403:
			model.addAttribute("msgErreur", "Vous n'avez pas l'autorisation");
			break;
		case 500:
			model.addAttribute("msgErreur", "une erreur interne c'est produite");
			break;
		default:
			model.addAttribute("msgErreur", "une erreur c'est produite");
		}
		model.addAttribute("codeErreur", codeErreur);
		return "error";
	}
}
