package fr.dawan.projet1.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "avis_articles")
public class AvisArticle implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne
	private Article article;

	@OneToOne
	private Utilisateur user;

	@Column(nullable = true)
	private String avis;

	@Column(nullable = true)
	private int note;

	@Version
	private int version;

	public AvisArticle() {
		super();
	}

	public AvisArticle(Article article, Utilisateur user, String avis, int note) {
		super();
		this.article = article;
		this.user = user;
		this.avis = avis;
		this.note = note;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public String getAvis() {
		return avis;
	}

	public void setAvis(String avis) {
		this.avis = avis;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "AvisArticle [id=" + id + ", article=" + article + ", user=" + user + ", avis=" + avis + ", note=" + note
				+ ", version=" + version + "]";
	}

}