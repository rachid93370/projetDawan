package fr.dawan.projet1.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "users")
public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false, length = 50)
	private String nom;

	@Column(nullable = false, length = 50)
	private String prenom;

	@Column(nullable = false, length = 250)
	private String email;

	@Column(nullable = false, length = 50)
	private String telephone;

	@Column(nullable = false, length = 250)
	private String motPasse;

	private LocalDate dateInscription;

	@Column(nullable = true)
	private LocalDate dateNaissance;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Adresse> adresseFacturation = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Adresse> adresseLivraison = new ArrayList<>();

	private int admin = 0;

	@OneToOne
	private Panier panier;

	@Version
	private int version;
	
	// Ajout pour les autorities et l'activation par email
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Authority> authorities = new HashSet<>();
	
	private boolean enabled;

	public Utilisateur() {
		super();
	}

	public Utilisateur(String nom, String prenom, String email, String telephone, String motPasse,
			LocalDate dateInscription) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.motPasse = motPasse;
		this.dateInscription = dateInscription;
	}

	public Utilisateur(String nom, String prenom, String email, String telephone, String motPasse,
			LocalDate dateInscription, LocalDate dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.motPasse = motPasse;
		this.dateInscription = dateInscription;
		this.dateNaissance = dateNaissance;
	}

	public Utilisateur(String nom, String prenom, String email, String telephone, String motPasse,
			LocalDate dateInscription, LocalDate dateNaissance, List<Adresse> adresseFacturation,
			List<Adresse> adresseLivraison) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.motPasse = motPasse;
		this.dateInscription = dateInscription;
		this.dateNaissance = dateNaissance;
		this.adresseFacturation = adresseFacturation;
		this.adresseLivraison = adresseLivraison;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotPasse() {
		return motPasse;
	}

	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public List<Adresse> getAdresseFacturation() {
		return adresseFacturation;
	}

	public void setAdresseFacturation(List<Adresse> adresse1) {
		this.adresseFacturation = adresse1;
	}

	public List<Adresse> getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(List<Adresse> adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

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

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", motPasse="
				+ motPasse + ", telephone=" + telephone + ", admin=" + admin + ", adresseFacturation="
				+ adresseFacturation + ", adresseLivraison=" + adresseLivraison + ", dateInscription=" + dateInscription
				+ ", dateNaissance=" + dateNaissance + ", panier=" + panier + ", version=" + version + "]";
	}

}