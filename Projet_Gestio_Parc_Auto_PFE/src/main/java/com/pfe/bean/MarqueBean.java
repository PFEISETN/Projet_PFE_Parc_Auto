package com.pfe.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.pfe.persistance.Marque;
import com.pfe.services.MarqueService;

@ManagedBean(name = "marquebean")
@SessionScoped
public class MarqueBean 
{
	
	private Integer numero_marque;
	private String nom_marque;
	private String action;
	List<Marque> mars=new 	ArrayList<Marque>();
	
	public List<Marque> getMars() {
	    mars=new MarqueService().rechercheTousMarque();
		return mars;
	}

	public void setMars(List<Marque> mars) {
		this.mars = mars;
	}
	

public Integer getNumero_marque() {
		return numero_marque;
	}

	public void setNumero_marque(Integer numero_marque) {
		this.numero_marque = numero_marque;
	}

	public String getNom_marque() {
		return nom_marque;
	}

	public void setNom_marque(String nom_marque) {
		this.nom_marque = nom_marque;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

public void Ajout(){
	   numero_marque=null;
	   nom_marque=null;
	   action="Ajouter";
   }

				public void modifier(Marque m){
					numero_marque=m.getNumero_marque();
					nom_marque=m.getNom_marque();
				    
					action="Modification";
				}

public void Validation(){
	
	FacesContext faces = FacesContext.getCurrentInstance();
	   Marque mar=new Marque();
	   if(nom_marque=="")
	   {
		   faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"vous dever remplire tous le Nom Marque !! ", "")); 
	   }else{
	        mar.setNom_marque(nom_marque);
	  	if(action!= null && action.equals("Ajouter")) 
		  { 
	  		
	  		 new MarqueService().ajouterMarque(mar);
	  		faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Marque ajoutée avec succès.", "")); 
		  }
			  
	  		if (action != null && action.equals("Modification")) {
				mar.setNumero_marque(numero_marque);
	  			new MarqueService().modifierMarque(mar);
				faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Marque modifiée avec succès.", ""));
			}
	   }
     
       
}



			public void supprimer(Marque m ) {
				 MarqueService ser=new MarqueService ();
				 ser.supprimerMarque(m);
				addMessage("suppression avec succee", ".");
			 }
			
			  
			 public void addMessage(String summary, String detail) {
			     FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
			     FacesContext.getCurrentInstance().addMessage(null, message);
			}

public void ClosDig(){
	 numero_marque=null;
	   nom_marque=null;
}
}
