package com.pfe.bean;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.pfe.persistance.Compte;
import com.pfe.persistance.Personnel;
import com.pfe.services.CompteService;

@ManagedBean(name = "connectBean")
@SessionScoped
public class ConnectBean 
{
	private Personnel p;
	private Integer matricule;
	private String login;
	private String motPasse;
	private String action;
	
	public Integer getmatricule() {
		return matricule;
	}


	public void setmatricule(Integer matricule) {
		this.matricule = matricule;
	}


	public String getAction() {
		return action;
	}
	

	public Personnel getP() {
		return p;
	}


	public void setP(Personnel p) {
		this.p = p;
	}


	public void setAction(String action) {
		this.action = action;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotPasse() {
		return motPasse;
	}

	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}

	
	public void ajout(Personnel p){
		login=null;
		motPasse=null;
		System.out.println("Matricule est "+p.getMatricule());
		action="Ajout";
	}
	
	public boolean existeCompte(String login, String motpass) {
		CompteService dao = new CompteService();
		Compte cmp = new Compte();
		cmp = dao.rechercheParUtilisateurMotPasse(login, motpass);
		if (cmp != null)
			// System.out.println(cmp.getMotDePasse());
			return true;

		else
			// System.out.println("compte nexiste pas");
			return false;
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public String connecter() {
		FacesContext faces = FacesContext.getCurrentInstance();
		if ((login.equals("") && motPasse.equals("")))
		{	
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_WARN, "erreur",
					"Vous dever remplire svp tout les champs "));
			login=null;
			motPasse=null;
	    }
		else if (login.equals("admin") && motPasse.equals("admin")) {
			return "/Templette.xhtml";
		}
		else if (existeCompte(login, motPasse)) {
			return "/Templette.xhtml";
		} 
		else
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "erreur",
					"Les informations saisie sont invalides "));
					login=null;
					return motPasse=null;
	}

	public void valider(Personnel p) {
		Compte cpt = new Compte();
		CompteService servi = new CompteService();
		cpt.setLogin(login);
		cpt.setMotDePasse(motPasse);
		cpt.setPersonnel(p);
		//cpt.setPersonnel(per);
		servi.AjouterCompte(cpt);
	}

	public void closeDiag() {
		login = null;
		motPasse = null;	
	}
	
 public void annuler()
   {
	    login = null;
		motPasse = null;
	}
	public String init() {
		login = null;
		motPasse = null;
		action = "Ajout";
		return null;
	}

}
