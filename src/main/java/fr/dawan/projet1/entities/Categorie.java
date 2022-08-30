package fr.dawan.projet1.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "categories")
public class Categorie implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String nom;

	@OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
	private List<Article> articles = new ArrayList<>();

	@Version
	private int version;

	public Categorie() {
		super();
	}

	public Categorie(String nom, List<Article> articles, int version) {
		super();
		this.nom = nom;
		this.articles = articles;
		this.version = version;
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

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Categorie(String nom) {
		super();
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nom=" + nom + ", articles=" + articles + ", version=" + version + "]";
	}

}