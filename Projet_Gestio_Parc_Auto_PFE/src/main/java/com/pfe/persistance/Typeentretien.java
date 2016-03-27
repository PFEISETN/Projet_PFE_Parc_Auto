package com.pfe.persistance;
import java.util.HashSet;
import java.util.Set;
public class Typeentretien  {

	private Integer numeroTypeE;
	private String nomTypeE;
	private Set<Entretien> entretiens = new HashSet<Entretien>(0);
    private Set<SousTypeEntretien> sousTypeEntretiens=new  HashSet<SousTypeEntretien>(0);
	
	public Typeentretien() {
	}

	public Typeentretien(Set<SousTypeEntretien> sousTypeEntretiens, String nomTypeE,
			Set<Entretien> entretiens) {
		this.sousTypeEntretiens = sousTypeEntretiens;
		this.nomTypeE = nomTypeE;
		this.entretiens = entretiens;
	}

	public Integer getNumeroTypeE() {
		return this.numeroTypeE;
	}

	public void setNumeroTypeE(Integer numeroTypeE) {
		this.numeroTypeE = numeroTypeE;
	}


	public String getNomTypeE() {
		return this.nomTypeE;
	}

	public void setNomTypeE(String nomTypeE) {
		this.nomTypeE = nomTypeE;
	}

	public Set<Entretien> getEntretiens() {
		return this.entretiens;
	}

	public void setEntretiens(Set<Entretien> entretiens) {
		this.entretiens = entretiens;
	}
	public Set<SousTypeEntretien> getSousTypeEntretiens() {
		return sousTypeEntretiens;
	}

	public void setSousTypeEntretiens(Set<SousTypeEntretien> sousTypeEntretiens) {
		this.sousTypeEntretiens = sousTypeEntretiens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nomTypeE == null) ? 0 : nomTypeE.hashCode());
		result = prime * result
				+ ((numeroTypeE == null) ? 0 : numeroTypeE.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Typeentretien other = (Typeentretien) obj;
		if (nomTypeE == null) {
			if (other.nomTypeE != null)
				return false;
		} else if (!nomTypeE.equals(other.nomTypeE))
			return false;
		if (numeroTypeE == null) {
			if (other.numeroTypeE != null)
				return false;
		} else if (!numeroTypeE.equals(other.numeroTypeE))
			return false;
		return true;
	}

}
