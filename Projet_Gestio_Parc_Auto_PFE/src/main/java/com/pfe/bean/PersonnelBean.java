package com.pfe.bean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.pfe.persistance.Compte;
import com.pfe.persistance.Departement;
import com.pfe.persistance.Personnel;
import com.pfe.persistance.Service;
import com.pfe.persistance.Typepersonnel;
import com.pfe.persistance.Ville;
import com.pfe.services.CompteService;
import com.pfe.services.DepartementService;
import com.pfe.services.PersonnelService;
import com.pfe.services.ServiceS;
import com.pfe.services.TypePersonnelService;
import com.pfe.services.VilleService;
@ManagedBean(name = "personnelbean")
@SessionScoped
public class PersonnelBean {
	private Integer matricule;
	private Compte compte;
	private String nom;
	private String prenom;
	private String telephone;
	private String cin;
	private Date dateNaissance;
	private String email;
	private String adresse;
	private String date_nai;
	private String numero_tel1;
	private String numero_tel2;
	private Integer numerocompte;
	private Integer numerodepartement;
	private Integer numeroservice;
	private Integer numerotypeP;
	private Integer idville;
	private String nomville;
	private String action;
	private Departement departementP;
	private Service serviceP;
	private Typepersonnel typePer;
	private Ville villeP;
    private String actionCompte;
 	
    public String getActionCompte() {
		return actionCompte;
	}

	public void setActionCompte(String actionCompte) {
		this.actionCompte = actionCompte;
	}

	public Departement getDepartementP() {
		return departementP;
	}

	public void setDepartementP(Departement departementP) {
		this.departementP = departementP;
	}

	public Service getServiceP() {
		return serviceP;
	}

	public void setServiceP(Service serviceP) {
		this.serviceP = serviceP;
	}

	public Typepersonnel getTypePer() {
		return typePer;
	}

	public void setTypePer(Typepersonnel typePer) {
		this.typePer = typePer;
	}

	public Ville getVilleP() {
		return villeP;
	}

	public void setVilleP(Ville villeP) {
		this.villeP = villeP;
	}

	public Integer getIdville() {
		return idville;
	}

	public void setIdville(Integer idville) {
		this.idville = idville;
	}

	public String getNomville() {
		return nomville;
	}

    public void setNomville(String nomville) {
		this.nomville = nomville;
	}

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

	List<Personnel> pls = new ArrayList<Personnel>();
    Personnel per = new Personnel();
	public List<Personnel> getPls() {
		pls = new PersonnelService().rechercheTousPersonnel();
		return pls;
	}
    
	private List<Personnel> filtrePersonnel;
	public List<Personnel> getFiltrePersonnel() {
		return filtrePersonnel;
	}

	public void setFiltrePersonnel(List<Personnel> filtrePersonnel) {
		this.filtrePersonnel = filtrePersonnel;
	}

	public Personnel chercherPer()
	{
		per=new PersonnelService().recherchePersonnelParId(matricule);
		return per;
	}
	
	public void setPls(List<Personnel> pls) {
		this.pls = pls;
	}
    List<Ville> vills=new ArrayList<Ville>();
	List<Compte> comptes = new ArrayList<Compte>();
	List<Departement> departements = new ArrayList<Departement>();
	List<Service> services = new ArrayList<Service>();
	List<Typepersonnel> typepersonnels = new ArrayList<Typepersonnel>();
    
	public List<Service> getServices() {
		services = new ServiceS().rechercheTousService();
		return services;
	}

	public List<Ville> getVills() {
		vills=new VilleService().rechercheTousVilleAvecJoin();
		return vills;
	}

	public void setVills(List<Ville> vills) {
		this.vills = vills;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public List<Typepersonnel> getTypepersonnels() {
		typepersonnels = new TypePersonnelService().rechercheTousTypePersonne();
		return typepersonnels;
	}

	public void setTypepersonnels(List<Typepersonnel> typepersonnels) {
		this.typepersonnels = typepersonnels;
	}

	public List<Departement> getDepartements() {
		departements = new DepartementService().rechercheTousDepartement();
		return departements;
	}

	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}

	public List<Compte> getComptes() {
		comptes = new CompteService().rechercheTousCompte();
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Integer getNumerocompte() {
		return numerocompte;
	}

	public void setNumerocompte(Integer numerocompte) {
		this.numerocompte = numerocompte;
	}

	public String getDate_nai() {
		return date_nai;
	}

	public void setDate_nai(String date_nai) {
		this.date_nai = date_nai;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Integer getMatricule() {
		return matricule;
	}

	public void setMatricule(Integer matricule) {
		this.matricule = matricule;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getNumerodepartement() {
		return numerodepartement;
	}

	public void setNumerodepartement(Integer numerodepartement) {
		this.numerodepartement = numerodepartement;
	}

	public Integer getNumeroservice() {
		return numeroservice;
	}

	public void setNumeroservice(Integer numeroservice) {
		this.numeroservice = numeroservice;
	}

	public Integer getNumerotypeP() {
		return numerotypeP;
	}

	public void setNumerotypeP(Integer numerotypeP) {
		this.numerotypeP = numerotypeP;
	}

	public void Ajout() {
		matricule = null;
		nom = null;
		prenom = null;
		telephone = null;
		cin = null;
		email = null;
		adresse = null;
		dateNaissance=null;
		numerodepartement = null;
		numeroservice = null;
     	numerotypeP = null;
     	idville=null;
     	numero_tel1=null;
		numero_tel2=null;
		action = "Ajouter";
		
	}

	public void Modifier(Personnel p) {
		matricule = p.getMatricule();
		nom = p.getNom();
		prenom = p.getPrenom();
		telephone = p.getTelephone();
		cin = p.getCin();
		email = p.getEmail();
		adresse = p.getAdresse();
		numero_tel1=p.getNumero_tel1();
		numero_tel2=p.getNumero_tel2();
        if (p.getDepartement() != null)
			numerodepartement = p.getDepartement().getNumeroDepartement();
        if (p.getVille() != null)
			idville = p.getVille().getId_ville();
        if (p.getService() != null)
			numeroservice = p.getService().getNumeroService();
	    if (p.getTypepersonnel() != null)
		numerotypeP = p.getTypepersonnel().getNumeroTypeP();
	    dateNaissance = p.getDateNaissance();
		action="Modification";
	}
	public void Validation()
	 { 
		FacesContext faces = FacesContext.getCurrentInstance();
		   Personnel p=new Personnel();
		   Boolean V=false;
		   if((nom =="")||(prenom =="")||(cin ==""))
		   { 
			   V=true;
			   faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"vous dever remplire tous les champs obligatoire !! ", "")); 
		   }
		 if(nom.matches("[+-]?\\d*(\\.\\d+)?"))
		   {  
			   V=true;
			   faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Ce nom est invalide !! ", "")); 
		   }
		   if(prenom.matches("[+-]?\\d*(\\.\\d+)?"))
		   { 
			   V=true;
			   faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Ce prenom est invalide !! ", "")); 
		   }
		  if ((telephone=="")&&((numero_tel1=="")&&(numero_tel2=="")))
		   {  
			   V=true;
			   faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Vous dever avoir au minimum un N° GSM !! ", "")); 
		   }
		  if ((cin.length() > 8)||((cin.length() < 8)))
		   {  
			   V=true;
			   faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Le numero du carte d'identité est invalide !! ", "")); 
		   }
         if((V==false)&&(email.matches("(?:\\w|[\\-_])+(?:\\.(?:\\w|[\\-_])+)*\\@(?:\\w|[\\-_])+(?:\\.(?:\\w|[\\-_])+)+")))
		{
            p.setEmail(email);
			p.setNom(nom);
			p.setPrenom(prenom);
			p.setCin(cin);
			p.setTelephone(telephone);
			p.setAdresse(adresse);
			p.setNumero_tel1(numero_tel1);
			p.setNumero_tel2(numero_tel2);
			Departement dep = new Departement();
			dep.setNumeroDepartement(numerodepartement);
			Ville v=new Ville();
			v.setId_ville(idville);
			Service s = new Service();
			s.setNumeroService(numeroservice);
			Typepersonnel typeP = new Typepersonnel();
			typeP.setNumeroTypeP(numerotypeP);
			p.setDateNaissance(dateNaissance);
			p.setEmail(email);
			p.setDepartement(dep);
			p.setService(s);
			p.setTypepersonnel(typeP);
			p.setVille(v);

            if(action!= null && action.equals("Ajouter")) 
			  { 
		  		new PersonnelService().AjouterPersonnel(p);
		  		faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Personne ajoutée avec succès.", "")); 
			  }
			 else  if (action != null && action.equals("Modification")) {
				 	p.setMatricule(matricule);
				 	System.out.println(matricule);
					new PersonnelService().modifierPersonnel(p);
					System.out.println("personnel modifier ");
					faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Personne modifiée avec succès.", ""));
			  }
			}

        else faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"l'adress Email est invalide .", "")); 
	 }

	public boolean Personel_Compte_NExiste(int x)
	{
		Compte cpt = new Compte();
		CompteService ser = new CompteService();
		cpt= ser.rechercheCompteParId(x);
		  if(cpt==null)
			 return true;
		  else return false;
		
	}
	
	
	
	public void supprimer(Personnel p) {
		FacesContext faces = FacesContext.getCurrentInstance();
		PersonnelService ser = new PersonnelService();
		matricule = p.getMatricule();
		if(Personel_Compte_NExiste(matricule))
		{
		   ser.supprimerPersonnel(p);
		   addMessage("suppression avec succee", ".");
		}
		else 
			faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Vous dever supprimer leur compte avant !!!", "")); 
	 }

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void closeDiag() {
		matricule = null;
		nom = null;
		prenom = null;
		dateNaissance = null;
		telephone = null;
		cin = null;
		email = null;
		adresse = null;
		idville=null;
		numerodepartement = null;
	    numeroservice = null;
 		numerotypeP = null;
		numero_tel1=null;
		numero_tel2=null;

	}

}
