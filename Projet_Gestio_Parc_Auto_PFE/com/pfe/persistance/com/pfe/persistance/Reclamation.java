package com.pfe.persistance;

// Generated 20 mars 2016 18:33:48 by Hibernate Tools 3.4.0.CR1

/**
 * Reclamation generated by hbm2java
 */
public class Reclamation implements java.io.Serializable {

	private Integer numeroReclamation;
	private Personnel personnel;
	private String description;

	public Reclamation() {
	}

	public Reclamation(Personnel personnel, String description) {
		this.personnel = personnel;
		this.description = description;
	}

	public Integer getNumeroReclamation() {
		return this.numeroReclamation;
	}

	public void setNumeroReclamation(Integer numeroReclamation) {
		this.numeroReclamation = numeroReclamation;
	}

	public Personnel getPersonnel() {
		return this.personnel;
	}

	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
