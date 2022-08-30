package fr.dawan.projet1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dawan.projet1.entities.Marque;

public interface MarqueRepository extends JpaRepository<Marque, Long> {
	
	Marque findByNom(String nom);

}