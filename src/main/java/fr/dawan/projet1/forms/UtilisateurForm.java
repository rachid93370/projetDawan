package fr.dawan.projet1.forms;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class UtilisateurForm {

	@NotBlank
	@Size(min = 2, max = 50)
	private String prenom;

	@NotBlank
	@Size(min = 2, max = 50)
	private String nom;

	@NotBlank
	@Email
	private String email;

	@Size(min = 10, max = 50)
	private String telephone;

	@NotBlank
	@Size(min = 6, max = 40)
	private String motPasse;
	
	private LocalDate dateInscription;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	private LocalDate dateNaissance;

//	@NotBlank
//	@Size(min = 6, max = 40)
//	private String confirmMotPass;
//
//	private int admin;

//	private List<Adresse> adresseFacturation = new ArrayList<>();
//
//	private List<Adresse> adresseLivraison = new ArrayList<>();

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

//	public String getConfirmMotPass() {
//		return confirmMotPass;
//	}
//
//	public void setConfirmMotPass(String confirmMotPass) {
//		this.confirmMotPass = confirmMotPass;
//	}
//
//	public int getAdmin() {
//		return admin;
//	}
//
//	public void setAdmin(int admin) {
//		this.admin = admin;
//	}

	public LocalDate getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(LocalDate dateInscription) {
		this.dateInscription = dateInscription;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

//	public List<Adresse> getAdresseFacturation() {
//		return adresseFacturation;
//	}
//
//	public void setAdresseFacturation(List<Adresse> adresseFacturation) {
//		this.adresseFacturation = adresseFacturation;
//	}
//
//	public List<Adresse> getAdresseLivraison() {
//		return adresseLivraison;
//	}
//
//	public void setAdresseLivraison(List<Adresse> adresseLivraison) {
//		this.adresseLivraison = adresseLivraison;
//	}

}