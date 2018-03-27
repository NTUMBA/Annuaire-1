package com.formation.annuaire1.canet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;


@Entity // On indique a Spring que cette classe est une Entite
@Table(name="personne")
public class Carnet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // fait reference a la persistence des data
	private Long id;
	
	@Enumerated(EnumType.STRING)// On cree un varchar et non un int
	@Column(length = 8 )// Un vachar de taille 8
	@NotNull(message="Veuillez cochez l' une des deux cases ") 
	private Civilite civilite ;
	
	@Pattern(regexp ="^(?i)[a-z]{2,50}$",message="{com.formation.annuaire1.contraint.Nom.message}") // le ?, i est un tag pour ignore la case (Maj min)
	private String nom;
	
	@Pattern(regexp ="^(?i)[a-z\\- ]{2,50}$",message="{com.formation.annuaire1.contraint.Prenom.message}") // le ?, i est un tag pour ignore la case (Maj min
	private String prenom;
	
	@Pattern(regexp ="^(?i)[a-z0-9._-]+@[a-z0-9._-]{2,}\\.[a-z]{2,4}$",message="{com.formation.annuaire1.contraint.Mail.message}")
	private String email;
	
	//@NotBlank
    //@Size(min = 6, max = 15)
	//private String passWord;
	
	@DateTimeFormat
	private String dateDeNaissance;
	
	//@Pattern(regexp ="^0[0-9]|[0]{2}[0-9]{6,14}(?:x.+)?$",message="{com.formation.annuaire1.contraint.Tel.message}")
	@Pattern(regexp ="(^0[1-68][0-9]{8}$)",message="{com.formation.annuaire1.contraint.Tel.message}")
	private String tel;

	@Pattern(regexp ="^[0-9]{5}$",message="{com.formation.annuaire1.contraint.Cp.message}")
	private String cp;
	
	@Pattern(regexp ="^(?i)[a-z]{1,45}$",message="{com.formation.annuaire1.contraint.Ville.message}") 
	private String ville;
	
	// CONSTRUCTEUR	
	
	// On modifie  le type de l id
	public Carnet(Long id, Civilite civilite,String nom, String prenom, String email, String dateDeNaissance, String tel,
			String cp, String ville) {
		this.id = id;
		this.civilite = civilite;
		this.setNom(nom);
		this.prenom = prenom;
		this.email = email;
		this.dateDeNaissance = dateDeNaissance;
		this.tel = tel;
		this.cp = cp;
		this.ville = ville;
	}
	public Carnet() {
		
	}
	
	// GETTERS ET SETTERS
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Civilite getCivilite() {
		return civilite;
	}
	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

}
