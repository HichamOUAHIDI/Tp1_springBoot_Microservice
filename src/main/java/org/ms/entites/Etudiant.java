package org.ms.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
//@Data
//@AllArgsConstructor demande a spring de genere un consrtucteur avec paramettre 
//@noArgsConstructor demande a spring de genere un constructeur sans paramettre

public class Etudiant implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	private String nom; 
	private String prenom; 
	private Date dateNaissance;
	
	@ManyToOne
	@JoinColumn(name="ID_FORMATION") // la relation manytone se represente par une cle etrangaire dans la base donner
	private Formation formation;
	
	
	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 * @param formation
	 */
	public Etudiant(Long id, String nom, String prenom, Date dateNaissance, Formation formation) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.formation = formation;
	}

	public Etudiant() {
		super();
	}
	
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	
	
}
