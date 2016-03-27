package com.pfe.bean;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.pfe.persistance.Departement;
import com.pfe.services.DepartementService;
@ManagedBean(name = "departementbean")
@SessionScoped
public class DepartementBean {
	private Integer numeroDepartement;
	private String nomDepartement;
	private String action;
	
	List<Departement>  deprts=new ArrayList<Departement>();
	
	public List<Departement> getDeprts() {
		deprts=new DepartementService().rechercheTousDepartement();
		return deprts;
	}
	public void setDeprts(List<Departement> deprts) {
		this.deprts = deprts;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Integer getNumeroDepartement() {
		return numeroDepartement;
	}
	public void setNumeroDepartement(Integer numeroDepartement) {
		this.numeroDepartement = numeroDepartement;
	}
	public String getNomDepartement() {
		return nomDepartement;
	}
	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}
	
	
	public void Ajout(){
		nomDepartement=null;
		action="Ajouter";
	}
				public void Modifier(Departement d){
					numeroDepartement=d.getNumeroDepartement();
					nomDepartement=d.getNomDepartement();
					
					action="Modification";
				}
				
    public void Valider (){
    	
    	FacesContext faces = FacesContext.getCurrentInstance();
    	Departement d=new Departement();
    	 if(nomDepartement =="")
		   { 
			   faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"vous dever remplire le nom departement !! ", "")); 
		   }
 	    else{
 	   d.setNomDepartement(nomDepartement);
 	   
 	  	if(action!= null && action.equals("Ajouter")) 
 		  { 
 	  		
 	  		 new DepartementService().ajouterDepartement(d);
 	  		faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
 					"Departement ajoutée avec succès.", "")); 
 		  }
 			  
 	  		if (action != null && action.equals("Modification")) {
 				d.setNumeroDepartement(numeroDepartement);
 				new DepartementService().modifierDepartement(d);
 				faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
 						"Departement modifiée avec succès.", ""));
 			}
 	    }
//        nom_categorie=null;
//        type_categorie=null;
        
    }
    
    public void supprimer(Departement d ) {
    	DepartementService ser=new DepartementService ();
		 ser.supprimerDepartement(d);
		addMessage("suppression avec succee", ".");
	 }
	
	  
	 public void addMessage(String summary, String detail) {
	     FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
	     FacesContext.getCurrentInstance().addMessage(null, message);
	}
    
    public void ClosDig(){
    	numeroDepartement=null;
    	nomDepartement=null;
   
    }
}