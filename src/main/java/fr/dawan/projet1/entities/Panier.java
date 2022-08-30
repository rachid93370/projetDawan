package fr.dawan.projet1.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import fr.dawan.projet1.enums.EtatPanier;

@Entity
@Table(name = "paniers")
public class Panier implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	private Utilisateur user;

	@OneToMany
	@Column(name="idVenteProduit")
	private List<VenteArticle> articles = new ArrayList<>();

	private int quantite;

	private double total;

	@Enumerated(EnumType.STRING)
	private EtatPanier EtatPanier;

	private LocalDate dateValidation;

	@Column(nullable = true)
	private LocalDate datePaiement;

	@Version
	private int version;

	public Panier() {
		super();
	}

	public Panier(Utilisateur user, List<VenteArticle> idVentePanier, int quantite, double total,
			fr.dawan.projet1.enums.EtatPanier etatPanier, LocalDate dateValidation) {
		super();
		this.user = user;
		this.articles = idVentePanier;
		this.quantite = quantite;
		this.total = total;
		EtatPanier = etatPanier;
		this.dateValidation = dateValidation;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public List<VenteArticle> getArticles() {
		return articles;
	}

	public void setArticles(List<VenteArticle> articles) {
		this.articles = articles;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public EtatPanier getEtatPanier() {
		return EtatPanier;
	}

	public void setEtatPanier(EtatPanier etatPanier) {
		EtatPanier = etatPanier;
	}

	public LocalDate getDateValidation() {
		return dateValidation;
	}

	public void setDateValidation(LocalDate dateValidation) {
		this.dateValidation = dateValidation;
	}

	public LocalDate getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(LocalDate datePaiement) {
		this.datePaiement = datePaiement;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Panier [id=" + id + ", user=" + user + ", articles=" + articles + ", quantite=" + quantite + ", total="
				+ total + ", EtatPanier=" + EtatPanier + ", dateValidation=" + dateValidation + ", datePaiement="
				+ datePaiement + ", version=" + version + "]";
	}

}