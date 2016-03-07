package com.pfe.persistance;
import java.util.HashSet;
import java.util.Set;
public class Panne {

	private Integer numeroPanne;
	private String typePanne;
	private Set<Reparation> reparations = new HashSet<Reparation>(0);
	private Set<RepPanne> repPannes = new HashSet<RepPanne>(0);

	public Panne() {
	}

	public Panne(String typePanne, Set<Reparation> reparations,
			Set<RepPanne> repPannes) {
		this.typePanne = typePanne;
		this.reparations = reparations;
		this.repPannes = repPannes;
	}

	public Integer getNumeroPanne() {
		return this.numeroPanne;
	}

	public void setNumeroPanne(Integer numeroPanne) {
		this.numeroPanne = numeroPanne;
	}

	public String getTypePanne() {
		return this.typePanne;
	}

	public void setTypePanne(String typePanne) {
		this.typePanne = typePanne;
	}

	public Set<Reparation> getReparations() {
		return this.reparations;
	}

	public void setReparations(Set<Reparation> reparations) {
		this.reparations = reparations;
	}

	public Set<RepPanne> getRepPannes() {
		return this.repPannes;
	}

	public void setRepPannes(Set<RepPanne> repPannes) {
		this.repPannes = repPannes;
	}

}
