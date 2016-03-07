package com.pfe.persistance;
public class RepPanne {

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
