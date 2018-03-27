package com.formation.annuaire1.canet;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Carnett {

	private int id;
	//@NotNull
	private Civilite civilite ;
	@NotBlank(message="Il faut remplir le champ nom")
	@Size(min =2, max =50, message="Pas assez de chiffres")
	private String nom;
	@NotBlank
	@Size(min =2, max =100)
	private String prenom;
	@NotBlank
	 @Pattern(regexp = "^a-zA-Z+a-zA-Z0-9\\._-*a-zA-Z0-9@a-zA-Z0-9a-zA-Z0-9\\._-*a-zA-Z0-9+\\.a-zA-Z{2,4}$")
	private String email;
	//@NotEmpty(message = "Please enter your password.")
    //@Size(min = 6, max = 15, message = "Your password must between 6 and 15 characters")
	//private String passWord;
	@NotBlank
	@DateTimeFormat
	private String dateDeNaissance;
	@NotBlank
	@Pattern(regexp ="^0[1-68][0-9]{8}$")
	private String tel;
	@NotBlank
	@Pattern(regexp ="^[0-9]{5}$")
	private String cp;
	@NotBlank
	@Size(min =2, max =80)
	private String ville;
	
	
	// CONSTRUCTEUR	
	public Carnett(int id, Civilite civilite,String nom, String prenom, String email, String dateDeNaissance, String tel,
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
	public Carnett() {
		
	}
	
	// GETTERS ET SETTERS
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
