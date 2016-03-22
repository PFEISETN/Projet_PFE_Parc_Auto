package com.pfe.bean;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.pfe.persistance.Mecanicien;
import com.pfe.services.MecanicienService;

@ManagedBean(name = "mecanicienbean")
@SessionScoped
public class MecanicienBean {
	private Integer numero_mec;
	private String nom_mecanicien;
	private String adresse;
	private String telephone;
	private String numero_tel1;
	private String numero_tel2;
	private String action;
	private Mecanicien selectedMecanicien;
	List<Mecanicien> Mecns=new ArrayList<Mecanicien>();
	
	public String getNumero_tel1() {
		return numero_tel1;
	}


	public void setNumero_tel1(String numero_tel1) {
		this.numero_tel1 = numero_tel1;
	}


	public String getNumero_tel2() {
		return numero_tel2;
	}


	public void setNumero_tel2(String numero_tel2) {
		this.numero_tel2 = numero_tel2;
	}


	public List<Mecanicien> getMecns() {
		Mecns=new MecanicienService().rechercheTousMecanicien();
		return Mecns;
	}
	
	
	public Mecanicien getSelectedMecanicien() {
		return selectedMecanicien;
	}


	public void setSelectedMecanicien(Mecanicien selectedMecanicien) {
		this.selectedMecanicien = selectedMecanicien;
	}


	public void setMecns(List<Mecanicien> mecns) {
		Mecns = mecns;
	}
	public Integer getNumero_mec() {
		return numero_mec;
	}
	public void setNumero_mec(Integer numero_mec) {
		this.numero_mec = numero_mec;
	}
	public String getNom_mecanicien() {
		return nom_mecanicien;
	}
	public void setNom_mecanicien(String nom_mecanicien) {
		this.nom_mecanicien = nom_mecanicien;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public void Ajout(){
		 numero_mec=null;
		 nom_mecanicien=null;
		 adresse=null;
		 telephone=null;
		 numero_tel1=null;
		 numero_tel2=null;
		 action="Ajouter";
		
	}
	
	public void Modifier(Mecanicien m)
	 { 
		numero_mec=m.getNumero_mec();
		nom_mecanicien=m.getNom_mecanicien();
		adresse=m.getAdresse();
		telephone=m.getTelephone();
		numero_tel1=m.getNumero_tel1();
		numero_tel2=m.getNumero_tel2();
		 action="Modification";
	 }
	
	public void validation(){
		FacesContext faces = FacesContext.getCurrentInstance();
		   boolean  V=false;
		   Mecanicien mec=new Mecanicien();
		 if((nom_mecanicien=="")&&(adresse=="")&&(telephone==""))
		   { 
			  V=true; 
			  faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"vous dever remplire tous les champs !! ", "")); 
		   }
		if(V==false)
		  {	  
			  if ((nom_mecanicien!="")&&(nom_mecanicien.matches("[+-]?\\d*(\\.\\d+)?")))
			  {  
				  V=true;
				  faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Ce nom est invalide !! ", "")); 
			   }
			  if((adresse.matches("[+-]?\\d*(\\.\\d+)?")&& (adresse!="")))
			   {  
				  V=true;
				  faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Cette adress est invalide !! ", "")); 
			   }
			 if ((telephone=="")&&((numero_tel1=="")&&(numero_tel2=="")))
			 {  
				 V=true;
				 faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Vous dever avoir au minimum un N° GSM !! ", "")); 
			 }
		  }	 
	   if(V==false)
	    {
		   mec.setNom_mecanicien(nom_mecanicien);
		   mec.setAdresse(adresse);
		   mec.setTelephone(telephone);
		   mec.setNumero_tel1(numero_tel1);
		   mec.setNumero_tel2(numero_tel2);
		  if(action!= null && action.equals("Ajouter")) 
			  { 
		  		new MecanicienService().ajouterMecanicien(mec);
		  		faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Mecanicien ajoutée avec succès.", "")); 
			  }
				  
		  else if (action != null && action.equals("Modification")) {
					mec.setNumero_mec(numero_mec);
					 new MecanicienService().modifierMecanicien(mec);
					faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Mecanicien modifiée avec succès.", ""));
				}
	    }
	   else  faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"Vous dever resaisie les informations !! ", "")); 
		
	}
	
	
	public void supprimer(Mecanicien m ) {
		MecanicienService ser=new MecanicienService();
   	 ser.supprimerMecanicien(m);
   	addMessage("suppression avec succee", ".");
	    }
	 
	     
	    public void addMessage(String summary, String detail) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	    
	public void closD(){
		 numero_mec=null;
		 nom_mecanicien=null;
		 adresse=null;
		 telephone=null;
		 numero_tel1=null;
		 numero_tel2=null;
	}

}
