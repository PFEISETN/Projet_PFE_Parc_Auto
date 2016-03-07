package com.pfe.bean;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import com.pfe.persistance.Panne;
import com.pfe.services.PanneService;
public class PanneBean {
	private Integer numeroPanne;
	private String typePanne;
	private String action;
	private List<Panne> pannes = new ArrayList<Panne>();
	 
	public List<Panne> getPannes() {
		return pannes;
	}
	public void setPannes(List<Panne> pannes) {
		this.pannes = pannes;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Integer getNumeroPanne() {
		return numeroPanne;
	}
	public void setNumeroPanne(Integer numeroPanne) {
		this.numeroPanne = numeroPanne;
	}
	public String getTypePanne() {
		return typePanne;
	}
	public void setTypePanne(String typePanne) {
		this.typePanne = typePanne;
	}

	public void ajouterPersonne() {

		numeroPanne = null ;
		typePanne= null ;
		action = "Ajout";
	}

	public void modifierPanne(Panne p) {
		numeroPanne=p.getNumeroPanne();
		typePanne=p.getTypePanne();
		action = "Modification";
	}

	public void validation() {
		FacesContext faces = FacesContext.getCurrentInstance();
		Panne p = new Panne();
		p.setTypePanne(typePanne);
		 if (action != null && action.equals("Ajout")) {
			new PanneService().AjouterPanne(p);
			faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"un nouveau panne ajouté avec succès.", ""));
		}

		if (action != null && action.equals("Modification")) {
			p.setNumeroPanne(numeroPanne);
			new PanneService().modifierPanne(p);
			faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Personnel modifiée avec succès.", ""));
		}

	}

	public void Supprimer(Panne p) {
		new PanneService().supprimerPanne(p);
		FacesContext faces = FacesContext.getCurrentInstance();
		faces.addMessage(null, new FacesMessage(
				"Panne supprimée avec succès."));
	}

	public void closeDiag() {
		numeroPanne=null;
		typePanne=null; 
	}	
	
	
	
}
