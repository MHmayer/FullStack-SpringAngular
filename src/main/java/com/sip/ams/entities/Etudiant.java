package com.sip.ams.entities;

public class Etudiant {

	private String id;
	private String nom;
	private String email;

	public Etudiant(String id, String nom, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
	}

	public Etudiant() {

	}

	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", email=" + email + "]";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
