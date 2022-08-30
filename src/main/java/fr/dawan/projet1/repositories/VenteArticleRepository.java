package fr.dawan.projet1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dawan.projet1.entities.VenteArticle;

public interface VenteArticleRepository extends JpaRepository<VenteArticle, Long> {

}