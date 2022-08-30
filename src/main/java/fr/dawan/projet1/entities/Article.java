package fr.dawan.projet1.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "articles")
public class Article implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String nom;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private double prix;

	@Lob
	private byte[] photo;

	@ManyToOne
	@JoinColumn(name = "idCategorie")
	private Categorie categorie;

	@ManyToOne
	@JoinColumn(name = "idMarque")
	private Marque marque;

	@Column(nullable = false)
	private int quantite;

	@Column(nullable = true)
	private double promo;

	@OneToMany(mappedBy = "article")
	private List<AvisArticle> avis = new ArrayList<>();

	// @OneToMany(mappedBy="article")
	// private List<Panier> panier = new ArrayList<>();

	public Article() {
		super();
	}

	public Article(String nom, String description, double prix, Categorie categorie, Marque marque, int quantite) {
		super();
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.categorie = categorie;
		this.marque = marque;
		this.quantite = quantite;
	}

	public Article(String nom, String description, double prix, byte[] photo, Categorie categorie, Marque marque,
			int quantite) {
		super();
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.photo = photo;
		this.categorie = categorie;
		this.marque = marque;
		this.quantite = quantite;
	}

	@Version
	private int version;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPromo() {
		return promo;
	}

	public void setPromo(double promo) {
		this.promo = promo;
	}

	public List<AvisArticle> getAvis() {
		return avis;
	}

	public void setAvis(List<AvisArticle> avis) {
		this.avis = avis;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", nom=" + nom + ", description=" + description + ", prix=" + prix + ", photo="
				+ Arrays.toString(photo) + ", categorie=" + categorie + ", marque=" + marque + ", quantite=" + quantite
				+ ", promo=" + promo + ", avis=" + avis + ", version=" + version + "]";
	}
	
	public boolean isEnStock_Articles(List<Panier> listePanier, Article article) {
		boolean result = true;
		for(Panier unPanier : listePanier){
			List<VenteArticle> listeVA = unPanier.getArticles();
			for(VenteArticle va : listeVA) {		
				if(va.getArticle().getQuantite() >= article.getQuantite()) {
					System.out.println(va.getArticle().getQuantite());
					result = false;
				}
			}
		}
		
		return result;
	}

}