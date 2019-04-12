package org.ms.entites;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Formation {
   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	private String nom; 
	private int duree;
	@OneToMany(mappedBy="formation") // une relation de plusieur a un 
	// une formation pour plusieur etudiants 
	
	private Collection<Etudiant> etudiants;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getDuree() {
		return duree;
	}
	
	/**
	 * 
	 */
	public Formation() {
		super();
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	/**
	 * @param id
	 * @param nom
	 * @param duree
	 * @param etudiants
	 */
	public Formation(Long id, String nom, int duree, Collection<Etudiant> etudiants) {
		super();
		this.id = id;
		this.nom = nom;
		this.duree = duree;
		this.etudiants = etudiants;
	}
	
	
	
}
