package com.pfe.bean;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.pfe.persistance.Panne;
import com.pfe.persistance.PieceRechange;
import com.pfe.persistance.RepPanne;
import com.pfe.persistance.Reparation;
import com.pfe.services.PanneService;
import com.pfe.services.RepPanneService;
import com.pfe.services.ReparationService;

@ManagedBean(name = "reparationBean")
@SessionScoped
public class ReparationBean {
	private Integer numeroReparation;
	private Panne panne;
	private PieceRechange pieceRechange;
	private Date dateDebRep;
	private Integer dureReparation;
	private Float prixReparation;
	private Date dateFinReparation;
	private String dateDRep;
	private String dateFDep;
	private String action;
	private Integer num_panne;
	private List<Reparation> reparations = new ArrayList<Reparation>();
	private List<Panne> pannes = new ArrayList<Panne>();
	private List<RepPanne> reppannes = new ArrayList<RepPanne>();
	private List<Panne> pannesSelect = new ArrayList<Panne>();

	public List<Panne> getPannesSelect() {
		return pannesSelect;
	}

	public void setPannesSelect(List<Panne> pannesSelect) {
		this.pannesSelect = pannesSelect;
	}

//	public void Recup_Liste() {
//		for(int i=0;i<4;i++)
//		pannesSelect.add(panne);
//		return pannesSelect;
//	}
	public void affiche() {
	    System.out.println("panne selectionner ");
	}
	public List<RepPanne> getReppannes() {
		reppannes = new RepPanneService().rechercheRep_PanParPanne(1);
		return reppannes;
	}

	public void setReppannes(List<RepPanne> reppannes) {
		this.reppannes = reppannes;
	}

	public List<RepPanne> listePanne(Integer num_panne) {
		RepPanneService repserv = new RepPanneService();
		List<RepPanne> liste = null;
		liste = repserv.rechercheRep_PanParPanne(num_panne);
		return liste;

	}

	public Integer getNum_panne() {
		return num_panne;
	}

	public void setNum_panne(Integer num_panne) {
		this.num_panne = num_panne;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getDateDRep() {
		return dateDRep;
	}

	public void setDateDRep(String dateDRep) {
		this.dateDRep = dateDRep;
	}

	public String getDateFDep() {
		return dateFDep;
	}

	public void setDateFDep(String dateFDep) {
		this.dateFDep = dateFDep;
	}

	public List<Reparation> getReparations() {
		reparations = new ReparationService().rechercheTousReparation();
		return reparations;
	}

	public void setReparations(List<Reparation> reparations) {
		this.reparations = reparations;
	}

	public List<Panne> getPannes() {
		pannes = new PanneService().rechercheTousPanne();
		return pannes;
	}

	public void setPannes(List<Panne> pannes) {
		this.pannes = pannes;
	}

	public Integer getNumeroReparation() {
		return numeroReparation;
	}

	public void setNumeroReparation(Integer numeroReparation) {
		this.numeroReparation = numeroReparation;
	}

	public Panne getPanne() {
		return panne;
	}

	public void setPanne(Panne panne) {
		this.panne = panne;
	}

	public PieceRechange getPieceRechange() {
		return pieceRechange;
	}

	public void setPieceRechange(PieceRechange pieceRechange) {
		this.pieceRechange = pieceRechange;
	}

	public Date getDateDebRep() {
		return dateDebRep;
	}

	public void setDateDebRep(Date dateDebRep) {
		this.dateDebRep = dateDebRep;
	}

	public Integer getDureReparation() {
		return dureReparation;
	}

	public void setDureReparation(Integer dureReparation) {
		this.dureReparation = dureReparation;
	}

	public Float getPrixReparation() {
		return prixReparation;
	}

	public void setPrixReparation(Float prixReparation) {
		this.prixReparation = prixReparation;
	}

	public Date getDateFinReparation() {
		return dateFinReparation;
	}

	public void setDateFinReparation(Date dateFinReparation) {
		this.dateFinReparation = dateFinReparation;
	}

	public void ajouterReparation() {
		numeroReparation = null;
		dureReparation = null;
		prixReparation = null;
		dateDebRep = null;
		dateFinReparation = null;
		dateDRep = null;
		dateFDep = null;
		num_panne = null;
		action = "Ajout";
	}

	public void modifierReparation(Reparation rep) {
		numeroReparation = rep.getNumeroReparation();
		dureReparation = rep.getDureReparation();
		prixReparation = rep.getPrixReparation();
		dateDebRep = rep.getDateDebRep();
		dateFinReparation = rep.getDateFinReparation();
		Format format = new SimpleDateFormat("dd/MM/yyyy");
		if (dateDebRep != null)
			dateDRep = format.format(dateDebRep);
		if (dateFinReparation != null)
			dateFDep = format.format(dateFinReparation);
//		if (rep.getPanne() != null)
//			num_panne = rep.getPanne().getNumeroPanne();

		action = "Modification";
	}

	public void validation() {
		FacesContext faces = FacesContext.getCurrentInstance();
		Reparation rep = new Reparation();
		rep.setPrixReparation(prixReparation);
//		Panne p = new Panne();
//		p.setNumeroPanne(num_panne);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		if (dateDRep != null)
			try {
				dateDebRep = sdf.parse(dateDRep);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		rep.setDateDebRep(dateDebRep);
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		if (dateFDep != null)
			try {
				dateFinReparation = sdf2.parse(dateFDep);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		rep.setDateFinReparation(dateFinReparation);
		rep.setDureReparation(dureReparation);
		//rep.setPanne(p);

		if (action != null && action.equals("Ajout")) {
			new ReparationService().AjouterReparation(rep);

			faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Une nouvelle réparation ajoutée avec succès.", ""));
		}

		if (action != null && action.equals("Modification")) {
			rep.setNumeroReparation(numeroReparation);
			new ReparationService().modifierReparation(rep);
			faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Réparation modifiée avec succès.", ""));
		}

	}

	public void Supprimer(Reparation rep) {
		new ReparationService().supprimerReparation(rep);
		FacesContext faces = FacesContext.getCurrentInstance();
		faces.addMessage(null, new FacesMessage(
				"Personnel supprimée avec succès."));
	}

	public void closeDiag() {
		numeroReparation = null;
		dureReparation = null;
		prixReparation = null;
		dateDebRep = null;
		dateFinReparation = null;
	}

}
