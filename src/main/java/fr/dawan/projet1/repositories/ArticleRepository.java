package fr.dawan.projet1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import fr.dawan.projet1.entities.Article;
import fr.dawan.projet1.entities.Categorie;
import fr.dawan.projet1.entities.Marque;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	
	@org.springframework.data.jpa.repository.Query ("select a from Article a where categorie = :id")
	List<Article> ArticleByCategorie(@Param("id") Categorie cat);
	
	@org.springframework.data.jpa.repository.Query ("select a from Article a where id = :id")
	List<Article> ArticleById(@Param("id") Long id);
	
	@org.springframework.data.jpa.repository.Query ("select a from Article a where marque = :id")
	List<Article> ArticleByMarque(@Param("id") Marque id);
	
	@org.springframework.data.jpa.repository.Query ("select a from Article a where promo != 0")
	List<Article> ArticleWithPromo();
	

}