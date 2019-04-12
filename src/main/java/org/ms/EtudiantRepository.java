package org.ms;

import java.util.List;

import org.ms.entites.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// avec spring data j'herite tout les methodes qui permet de gere les etudiants 
@RepositoryRestResource
// cette annotation dit a spring tout les methodes dans cette interface  je voudrais quel soit accesible via une api rest  
public interface EtudiantRepository 
extends JpaRepository<Etudiant, Long> {
	public List<Etudiant> findByNomContains(String nom);
}
