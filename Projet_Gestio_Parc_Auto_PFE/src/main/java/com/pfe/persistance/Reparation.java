package com.pfe.persistance;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
public class Reparation{

	private Integer numeroReparation;
	private Panne panne;
	private PieceRechange pieceRechange;
	private Date dateDebRep;
	private Integer dureReparation;
	private Float prixReparation;
	private Date dateFinReparation;
	private Set<RepPanne> repPannes = new HashSet<RepPanne>(0);
	
	public Reparation() {
	}

	public Reparation(Panne panne, PieceRechange pieceRechange,
			Date dateDebRep, Integer dureReparation, Float prixReparation,
			Date dateFinReparation, Set<RepPanne> repPannes) {
		this.panne = panne;
		this.pieceRechange = pieceRechange;
		this.dateDebRep = dateDebRep;
		this.dureReparation = dureReparation;
		this.prixReparation = prixReparation;
		this.dateFinReparation = dateFinReparation;
		this.repPannes = repPannes;
	}

	public Integer getNumeroReparation() {
		return this.numeroReparation;
	}

	public void setNumeroReparation(Integer numeroReparation) {
		this.numeroReparation = numeroReparation;
	}

	public Panne getPanne() {
		return this.panne;
	}

	public void setPanne(Panne panne) {
		this.panne = panne;
	}

	public PieceRechange getPieceRechange() {
		return this.pieceRechange;
	}

	public void setPieceRechange(PieceRechange pieceRechange) {
		this.pieceRechange = pieceRechange;
	}

	public Date getDateDebRep() {
		return this.dateDebRep;
	}

	public void setDateDebRep(Date dateDebRep) {
		this.dateDebRep = dateDebRep;
	}

	public Integer getDureReparation() {
		return this.dureReparation;
	}

	public void setDureReparation(Integer dureReparation) {
		this.dureReparation = dureReparation;
	}

	public Float getPrixReparation() {
		return this.prixReparation;
	}

	public void setPrixReparation(Float prixReparation) {
		this.prixReparation = prixReparation;
	}

	public Date getDateFinReparation() {
		return this.dateFinReparation;
	}

	public void setDateFinReparation(Date dateFinReparation) {
		this.dateFinReparation = dateFinReparation;
	}

	public Set<RepPanne> getRepPannes() {
		return this.repPannes;
	}

	public void setRepPannes(Set<RepPanne> repPannes) {
		this.repPannes = repPannes;
	}

}
