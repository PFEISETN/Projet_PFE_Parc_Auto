package com.pfe.bean;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.pfe.persistance.Typepersonnel;
import com.pfe.services.TypePersonnelService;

@ManagedBean(name = "typepersonnelbean")
@SessionScoped
public class TypePersonnelBean {
	 private Integer numero_typeP;
	 private String  nom_typeP;
	 private String action;
	 
	 
	 List<Typepersonnel> typsPs=new ArrayList<Typepersonnel>();
	    
	public List<Typepersonnel> getTypsPs() {
		typsPs=new TypePersonnelService().rechercheTousTypePersonne();
		return typsPs;
	}
	public void setTypsPs(List<Typepersonnel> typsPs) {
		this.typsPs = typsPs;
	}
	public Integer getNumero_typeP() {
		return numero_typeP;
	}
	public void setNumero_typeP(Integer numero_typeP) {
		this.numero_typeP = numero_typeP;
	}
	public String getNom_typeP() {
		return nom_typeP;
	}
	public void setNom_typeP(String nom_typeP) {
		this.nom_typeP = nom_typeP;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	 
	 
	
	public void ajout()
	{
		nom_typeP=null;
		action="Ajouter";
		
	}
	
	public void Modifier(Typepersonnel typ){
		numero_typeP=typ.getNumeroTypeP();
		nom_typeP=typ.getNomTypeP();
		action="Modification";
	}
	
	
	
	public void Valider(){
		FacesContext faces = FacesContext.getCurrentInstance();
		Typepersonnel typeP=new Typepersonnel();
		 if(nom_typeP=="")
		   { 
			   faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"vous dever remplire le nom type Personnel !! ", "")); 
		   }
	    else{
		typeP.setNomTypeP(nom_typeP);
	  	if(action!= null && action.equals("Ajouter")) 
		  { 
	  		 new TypePersonnelService().ajouterTypeP(typeP);
	  		faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Type Personnel ajoutée avec succès.", "")); 
		  }
			  
	  		if (action != null && action.equals("Modification")) {
				typeP.setNumeroTypeP(numero_typeP);
				 new TypePersonnelService().modifierTypePersonnel(typeP);
				faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Type Personnel modifiée avec succès.", ""));
			}
	    }
	}
	
	 public void supprimer(Typepersonnel ty ) {
	    	TypePersonnelService ser=new TypePersonnelService();
			 ser.supprimerTypePersonnel(ty);
			addMessage("suppression avec succee", ".");
		 }
		
		  
		 public void addMessage(String summary, String detail) {
		     FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		     FacesContext.getCurrentInstance().addMessage(null, message);
		}

	    
	
	public void ClosDig(){
		numero_typeP=null;
		nom_typeP=null;
	}
}