package fr.dawan.projet1.forms;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class UserForm {

	@NotBlank
	@Size(min = 2, max = 50)
	private String prenom;

	@NotBlank
	@Size(min = 2, max = 50)
	private String nom;

	@NotBlank
	@Email
	@Size(max = 250)
	private String email;

	@Size(min = 10, max = 50)
	private String telephone;

	@NotBlank
	@Size(min = 6, max = 50)
	private String motPasse;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	private LocalDate dateNaissance;
	

	@NotBlank
	@Size(min = 6, max = 40)
	private String confirmMotPasse;


	@NotBlank
	@Size(max = 4)
	private String numero;
	
	@NotBlank
	@Size(max = 255)
	private String rue;
	
	@NotBlank
	@Size(min = 5, max = 6)
	private String codePostal;
	
	@NotBlank
	@Size(max = 255)
	private String ville;


	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMotPasse() {
		return motPasse;
	}

	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}

	public String getConfirmMotPasse() {
		return confirmMotPasse;
	}

	public void setConfirmMotPasse(String confirmMotPasse) {
		this.confirmMotPasse = confirmMotPasse;
	}


	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	
	

}
