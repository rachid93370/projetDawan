package fr.dawan.projet1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dawan.projet1.entities.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

	VerificationToken findByToken(String token);

}