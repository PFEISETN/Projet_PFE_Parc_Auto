package com.pfe.bean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.pfe.persistance.Typepersonnel;
import com.pfe.services.TypePersonnelService;
@ManagedBean(name = "typepersonnelbean")
@SessionScoped
public class TypePersonnelBean {
	 private Integer numero_typeP;
	 private String  nom_typeP;
	 private String action;
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
	
	public void Valider(){
		Typepersonnel typeP=new Typepersonnel();
		typeP.setNomTypeP(nom_typeP);
		TypePersonnelService ser=new TypePersonnelService(); 
	  	if(action!= null && action.equals("Ajouter")) 
		ser.ajouterTypeP(typeP);
		
	}
	
	public void ClosDig(){
		numero_typeP=null;
		nom_typeP=null;
	}
}