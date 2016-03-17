package com.pfe.bean;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.pfe.persistance.Personnel;
import com.pfe.persistance.Ville;
import com.pfe.services.PersonnelService;
import com.pfe.services.VilleService;
@ManagedBean(name = "villeBean")
@SessionScoped
public class VilleBean {
	private Integer idville;
	private String nom_Ville;
	private List<Ville> villes = new ArrayList<Ville>();
	private String action;

	public String getnom_Ville() {
		return nom_Ville;
	}

	public void setnom_Ville(String nom_Ville) {
		this.nom_Ville = nom_Ville;
	}

	public Integer getId_Ville() {
		return idville;
	}

	public void setIdville(Integer idville) {
		this.idville = idville;
	}

	public List<Ville> getVilles() {
		VilleService ser = new VilleService();
		villes = ser.rechercheTousVille();
		System.out.println("size"+villes.size());
		return villes;
	}

	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void ajouterVille() {
		action = "Ajout";
	}

	public void validation() {
		Ville v = new Ville();
		v.setNom_ville(nom_Ville);
		List<Ville> lV = new VilleService().rechercheVilleParNom(nom_Ville);
		FacesContext faces = FacesContext.getCurrentInstance();
		if (action != null && action.equals("Ajout"))
		 {
			if (lV != null && lV.size() > 0)
			   faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ville existe déjà.", ""));
    	  else { 
			     new VilleService().ajouterVille(v);
			     faces.addMessage(null, new FacesMessage( FacesMessage.SEVERITY_INFO, "Ville ajoutée avec succès.", ""));
			   }
		 }
		else if (action != null && action.equals("Modification")) 
		{
			if (lV != null && lV.size() > 0)
			 {
				if (lV.get(0).getId_ville().equals(idville))
					faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ville existe déjà.",""));
				else {
					v.setId_ville(idville);
					new VilleService().modifierVille(v);
					faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_INFO,
							"Ville modifiée avec succès.", ""));
					}
			   }
		    }
		idville = null;
		nom_Ville = null;
	}
	
	     
	    public void addMessage(String summary, String detail) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }

	public void supprimer(Ville v) {
		FacesContext faces = FacesContext.getCurrentInstance();
//	// chercher si cette ville est liée à une personne ou une société
     	List<Personnel> lp= new PersonnelService().recherchePersonnelParVille(v.getId_ville());
//	
		if ((lp != null && lp.size() > 0))
	 {
		faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Suppression impossible! ", ""));
	} else {
			new VilleService().supprimerVille(v);
		faces.addMessage(null, new FacesMessage(
					"Ville supprimée avec succès."));
		}
	}

	public void modifierVille(Ville v) {
		action = "Modification";
		idville = v.getId_ville();
		nom_Ville = v.getNom_ville();
	}

	public void closeDiag() {
		idville = null;
		nom_Ville = null;
	}

}