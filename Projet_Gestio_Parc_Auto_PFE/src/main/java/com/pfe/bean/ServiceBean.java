package com.pfe.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.pfe.persistance.Service;
import com.pfe.services.ServiceS;

@ManagedBean(name = "servicebean")
@SessionScoped
public class ServiceBean {
	private String nom_Service;
	private String action;
	private Integer numero_Service;
	
	public Integer getNumero_Service() {
		return numero_Service;
	}
	public void setNumero_Service(Integer numero_Service) {
		this.numero_Service = numero_Service;
	}
	public String getNom_Service() {
		return nom_Service;
	}
	public void setNom_Service(String nom_Service) {
		this.nom_Service = nom_Service;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}

	public void ajout(){
		numero_Service=null;
		nom_Service=null;
		action="Ajout";
	}
	
	public void valider() {
		Service cpt = new Service();
		ServiceS servi = new ServiceS();
		cpt.setNomService(nom_Service);
		if ((action != null) && (action.equals("Ajout"))) {
			servi.ajouterService(cpt);
			System.out.print("ok");
		}
	}
    
    public void supprimer(Service s ) {
    	ServiceS ser=new ServiceS();
		 ser.supprimerService(s);
		addMessage("suppression avec succee", ".");
	 }
	
	  
	 public void addMessage(String summary, String detail) {
	     FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
	     FacesContext.getCurrentInstance().addMessage(null, message);
	}

    
    public void ClosDig(){
    	numero_Service=null;
    	nom_Service=null;
   
    }
	
}