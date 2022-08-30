package fr.dawan.projet1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import fr.dawan.projet1.entities.Adresse;
import fr.dawan.projet1.entities.Article;
import fr.dawan.projet1.entities.AvisArticle;
import fr.dawan.projet1.entities.Categorie;
import fr.dawan.projet1.entities.Marque;
import fr.dawan.projet1.entities.Panier;
import fr.dawan.projet1.entities.Utilisateur;
import fr.dawan.projet1.entities.VenteArticle;
import fr.dawan.projet1.enums.EtatPanier;
import fr.dawan.projet1.repositories.AdresseRepository;
import fr.dawan.projet1.repositories.ArticleRepository;
import fr.dawan.projet1.repositories.AvisArticleRepository;
import fr.dawan.projet1.repositories.CategorieRepository;
import fr.dawan.projet1.repositories.MarqueRepository;
import fr.dawan.projet1.repositories.PanierRepository;
import fr.dawan.projet1.repositories.UtilisateurRepository;
import fr.dawan.projet1.repositories.VenteArticleRepository;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	AdresseRepository adresseRepository;

	@Autowired
	UtilisateurRepository utilisateurRepository;

	@Autowired
	MarqueRepository marqueRepository;

	@Autowired
	CategorieRepository categorieRepository;

	@Autowired
	ArticleRepository articleRepository;

	@Autowired
	PanierRepository panierRepository;

	@Autowired
	VenteArticleRepository venteArticleRepository;

	@Autowired
	AvisArticleRepository avisArticleRepository;

	@Override
	public void run(String... args) throws Exception {

		// -- MARQUES --//

		Marque marque1 = new Marque("Sony");
//		marqueRepository.saveAndFlush(marque1);
//
		Marque marque2 = new Marque("Nintendo");
//		marqueRepo.saveAndFlush(marque2);
//
		Marque marque3 = new Marque("MicroSoft");
//		marqueRepo.saveAndFlush(marque3);
//
		Marque marque4 = new Marque("Atari");
//		marqueRepo.saveAndFlush(marque4);
//
//		// -- CATEGORIES --//
//		
		Categorie categorie1 = new Categorie("Consoles");
//		categorieRepository.saveAndFlush(categorie1);
//
		Categorie categorie2 = new Categorie("Jeux récents");
//		categorieRepo.saveAndFlush(categorie2);
//
		Categorie categorie3 = new Categorie("Carte de paiement");
//		categorieRepo.saveAndFlush(categorie3);
//
		Categorie categorie4 = new Categorie("Jeux rétros");
//		categorieRepo.saveAndFlush(categorie4);
//
		Categorie categorie5 = new Categorie("Bornes");
//		categorieRepo.saveAndFlush(categorie5);
//
		Categorie categorie6 = new Categorie("Manettes");
//		categorieRepo.saveAndFlush(categorie6);
//
		Categorie categorie7 = new Categorie("Cables");
//		categorieRepo.saveAndFlush(categorie7);
//
		Categorie categorie8 = new Categorie("Adaptateurs");
//		categorieRepo.saveAndFlush(categorie8);
//
//		// -- ADRESSES --//
//
//		Adresse adresse1 = new Adresse(3, "rue terre-neuve", "80000", "chien");
////		adresseRepo.saveAndFlush(adresse1);
////
//		Adresse adresse2 = new Adresse(13, "rue terre-neuve", "80700", "cheval");
////		adresseRepo.saveAndFlush(adresse2);
////
//		Adresse adresse3 = new Adresse(23, "rue terre-neuve", "83000", "requin");
////		adresseRepo.saveAndFlush(adresse3);
////
//		Adresse adresse4 = new Adresse(15, "rue terre-neuve", "84000", "poney");
////		adresseRepo.saveAndFlush(adresse4);
////
//		Adresse adresse5 = new Adresse(5, "rue terre-neuve", "80025", "ane");
////		adresseRepo.saveAndFlush(adresse5);
////
//		Adresse adresse6 = new Adresse(3, "rue terre-neuve", "80000", "singe");
////		adresseRepo.saveAndFlush(adresse6);
////
//		Adresse adresse7 = new Adresse(13, "rue terre-neuve", "80700", "elephant");
////		adresseRepo.saveAndFlush(adresse7);
////
//		Adresse adresse8 = new Adresse(23, "rue terre-neuve", "83000", "hippopotame");
////		adresseRepo.saveAndFlush(adresse8);
////
//		Adresse adresse9 = new Adresse(15, "rue terre-neuve", "84000", "licorne");
////		adresseRepo.saveAndFlush(adresse9);
////
//		Adresse adresse10 = new Adresse(5, "rue terre-neuve", "80025", "centaure");
////		adresseRepo.saveAndFlush(adresse10);
////
//		// -- Liste d'adresses --//
//
		List<Adresse> listeAdr1 = new ArrayList<>();
//		listeAdr1.add(adresse1);
//
		List<Adresse> listeAdr2 = new ArrayList<>();
//		listeAdr2.add(adresse3);
//		listeAdr2.add(adresse5);
//
		List<Adresse> listeAdr3 = new ArrayList<>();
//		listeAdr3.add(adresse1);
//		listeAdr3.add(adresse7);
//
		List<Adresse> listeAdr4 = new ArrayList<>();
//		listeAdr4.add(adresse8);
//		listeAdr4.add(adresse9);
//
//		// -- UTILISATEURS --//
//		/*
//		 * Utilisateur(String nom, String prenom, String email, String motPasse, String
//		 * telephone, LocalDate dateInscription)
//		 */
//
//		Utilisateur user1 = new Utilisateur("nom1", "prenom1", "user1.user1@user.fr", "test", "1234567890",
//				LocalDate.now());
//		user1.setAdmin(1);
//		utilisateurRepo.saveAndFlush(user1);
//
//		Utilisateur user2 = new Utilisateur("nom2", "prenom2", "user2.user2@user.fr", "test", "1988998990",
//				LocalDate.now());
//		user2.setAdresseFacturation(listeAdr1);
//		user2.setAdresseLivraison(listeAdr2);
//		utilisateurRepo.saveAndFlush(user2);
//
//		Utilisateur user3 = new Utilisateur("nom3", "prenom3", "user3.use32@user.fr", "test", "0770154438",
//				LocalDate.now());
//		user3.setAdresseFacturation(listeAdr3);
//		user3.setAdresseLivraison(listeAdr4);
//		utilisateurRepo.saveAndFlush(user3);
//
////		Utilisateur user4 = new Utilisateur("nom4", "prenom4", "user4.user4@user.fr", 
////				"test", "0770154438", LocalDate.now());
////		utilisateurRepo.saveAndFlush(user4);
//
//		// -- ARTICLES --//
//		/*
//		 * Article(String nom, String description, double prix, byte[] photo, Categorie
//		 * categorie, Marque marque, int quantite)
//		 */
//
		Article article1 = new Article("Nintendo DS", "console d'occasion Nintendo DS grise", 30.0, categorie1, marque2,
				3);
//		articleRepo.saveAndFlush(article1);
//
		Article article2 = new Article("Nintendo 3DS", "console d'occasion Nintendo 3DS bleue", 25.0, categorie1,
				marque2, 4);
//		articleRepo.saveAndFlush(article2);
//
		Article article3 = new Article("PlayStation 1", "console d'occasion PlayStation 1 grise", 50.0, categorie1,
				marque1, 3);
		article3.setPromo(45);
//		articleRepository.saveAndFlush(article3);
//
		Article article4 = new Article("PlayStation 2", "console d'occasion PlayStation 2 bleue", 45.0, categorie1,
				marque1, 4);
//		articleRepo.saveAndFlush(article4);
//
//		// --VENTE_ARTICLE--//
//		
//		VenteArticle va1 = new VenteArticle(article1, user2, 2);
//		venteArticleRepo.saveAndFlush(va1);// 60(30*2)
//
//		VenteArticle va2 = new VenteArticle(article2, user2, 1);
//		venteArticleRepo.saveAndFlush(va2);// 25
//
//		VenteArticle va3 = new VenteArticle(article4, user2, 2);
//		venteArticleRepo.saveAndFlush(va3);// 90(45*2)
//
//		// -- Liste d'articles --//
//		List<VenteArticle> listeArticles1 = new ArrayList<>();
//		listeArticles1.add(va1);
//		listeArticles1.add(va2);
//		listeArticles1.add(va3);
//
//		System.out.println(listeArticles1.get(0).toString());
//		System.out.println(listeArticles1.get(1).toString());
//		
//		// -- PANIERS --//
//		/*
//		 * Panier(Utilisateur user, List<Article> articles, int quantite, double total,
//		 * fr.dawan.projet2.enums.EtatPanier etatPanier, LocalDate dateValidation)
//		 */
//
//		Panier panier = new Panier(user2, listeArticles1, listeArticles1.get(0).getQte(), 60.0, EtatPanier.VALIDE,
//				LocalDate.now());
//		panierRepo.saveAndFlush(panier);

		System.out.println(panierRepository.CalculTotal());

//		utilisateurRepository.deleteById(3L);

		// -- AVIS_ARTICLE --//

//		AvisArticle avis1 = new AvisArticle(article1, user2, "bon test", 2);
//		avisArticleRepository.saveAndFlush(avis1);
//
//		AvisArticle avis2 = new AvisArticle(article4, user3, "bon achat", 1);
//		avisArticleRepository.saveAndFlush(avis2);

//		System.out.println("--- ArticleByCategorie -----");
//		List<Article> listeTestCategorie = articleRepository.ArticleByCategorie(categorie5);
//		for (Article unArticle : listeTestCategorie) {
//			System.out.println(unArticle.getNom());
//		}
		
//		System.out.println("--- ArticleByMarque -----");
//		List<Article> listeTestMarque = articleRepository.ArticleByMarque(marque1);
//		for (Article unArticle2 : listeTestMarque) {
//			System.out.println(unArticle2.getNom());
//		}
		
		System.out.println("--- ArticleWithPromo -----");
		List<Article> listeTestPromo = articleRepository.ArticleWithPromo();
		for (Article unArticle3 : listeTestPromo) {
			System.out.println(unArticle3.getNom());
		}

//		List<Panier> listePanier = panierRepository.findAll();
//		boolean result = article1.isEnStock_Articles(listePanier, article1);
//		System.out.println(result);
	}

}
