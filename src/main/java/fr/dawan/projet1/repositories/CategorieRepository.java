package fr.dawan.projet1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dawan.projet1.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

	Categorie findByNom(String nom);
}