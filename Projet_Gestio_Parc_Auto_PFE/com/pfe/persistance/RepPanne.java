package com.pfe.persistance;

// Generated 29 f�vr. 2016 10:37:19 by Hibernate Tools 3.4.0.CR1

/**
 * RepPanne generated by hbm2java
 */
public class RepPanne implements java.io.Serializable {

	private Integer idRepPanne;
	private Reparation reparation;
	private Panne panne;

	public RepPanne() {
	}

	public RepPanne(Reparation reparation, Panne panne) {
		this.reparation = reparation;
		this.panne = panne;
	}

	public Integer getIdRepPanne() {
		return this.idRepPanne;
	}

	public void setIdRepPanne(Integer idRepPanne) {
		this.idRepPanne = idRepPanne;
	}

	public Reparation getReparation() {
		return this.reparation;
	}

	public void setReparation(Reparation reparation) {
		this.reparation = reparation;
	}

	public Panne getPanne() {
		return this.panne;
	}

	public void setPanne(Panne panne) {
		this.panne = panne;
	}

}
