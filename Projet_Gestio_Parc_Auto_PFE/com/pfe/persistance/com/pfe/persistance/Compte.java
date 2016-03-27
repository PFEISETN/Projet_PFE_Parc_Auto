package com.pfe.persistance;

// Generated 20 mars 2016 18:33:48 by Hibernate Tools 3.4.0.CR1

/**
 * Compte generated by hbm2java
 */
public class Compte implements java.io.Serializable {

	private Integer matricule;
	private Personnel personnel;
	private String login;
	private String motDePasse;

	public Compte() {
	}

	public Compte(Personnel personnel) {
		this.personnel = personnel;
	}

	public Compte(Personnel personnel, String login, String motDePasse) {
		this.personnel = personnel;
		this.login = login;
		this.motDePasse = motDePasse;
	}

	public Integer getMatricule() {
		return this.matricule;
	}

	public void setMatricule(Integer matricule) {
		this.matricule = matricule;
	}

	public Personnel getPersonnel() {
		return this.personnel;
	}

	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

}