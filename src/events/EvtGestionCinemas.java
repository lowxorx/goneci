/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import dao.CinemaDAO;
import dao.SallesDAO;
import metier.Cinema;
import metier.Salle;
import panels.PanelGestionCinemas;

/**
 *
 * @author Bastien
 */
public class EvtGestionCinemas implements ActionListener {

	PanelGestionCinemas cinema;

	public EvtGestionCinemas(PanelGestionCinemas panelGestionSalles) {
		super();
		this.cinema = panelGestionSalles;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cinema.getBtRetour()) {
			showadminpage();
		} else if (e.getSource() == cinema.getBtRefresh()) {
			List<Cinema> cine = refreshcinemas();
			if (cine == null) {
				JOptionPane.showMessageDialog(cinema, "Erreur pendant la récupération de la liste des cinémas");
			} else {
				for (Iterator<Cinema> i = cine.iterator(); i.hasNext();) {
					Cinema c = i.next();
					cinema.setCbListeCinemas(c.getNomcinema());
				}
			}
		} else if (e.getSource() == cinema.getCbListeCinemas()) {
			List<Salle> cine = refreshsalles();
			if (cine == null) {
				JOptionPane.showMessageDialog(cinema, "Erreur pendant la récupération de la liste des salles");
			} else {
				int nbsalles = 0;
				for (Iterator<Salle> i = cine.iterator(); i.hasNext();) {
					Salle salle = i.next();
					cinema.setCbListSalles(String.valueOf((salle.getNuméro())));
					nbsalles++;
				}
				Cinema detailscine = detailsCinema();
				if (detailscine != null) {
					cinema.setIdCine(detailscine.getIdCinema());
					cinema.setTbNomCine(detailscine.getNomcinema());
					cinema.setTbTarif3dCine(String.valueOf(detailscine.getTarif3D()));
					cinema.setTbTarifEtudiantCine(String.valueOf(detailscine.getTarifEtudiant()));
					cinema.setTbTarifNormalCine(String.valueOf(detailscine.getTarifNormal()));
				}
				cinema.setTbNbSalleCine(String.valueOf(nbsalles));
			}
		} else if (e.getSource() == cinema.getBtRefreshInfoSalle()) {
			if (cinema.getCbListSalles() != null) {
				Salle salle = detailsSalle();
				if (salle != null) {
					cinema.setIdSalle(salle.getIdSalle());
					cinema.setTbCine(salle.getCinema().toString());
					cinema.setTbNbRangees(String.valueOf(salle.getNbRangées()));
					cinema.setTbNbSieges(String.valueOf(salle.getNbSiegeRangées()));
					cinema.setTbNumSalle(String.valueOf(salle.getNuméro()));
					cinema.setTbNbPlacesHandi(String.valueOf(salle.getNbSiegeHandi()));
					cinema.setTbNbPlacesToTal(String.valueOf(salle.getNbPlacesTotal()));
					cinema.setCbTypeEcran(salle.getTypeEcran());
					cinema.setCbTypeSon(salle.getTypeSon());
				}
			}
		} else if (e.getSource() == cinema.getBtDelSalle()) {
			boolean delete = deletesalle();
			if (delete == false) {
				JOptionPane.showMessageDialog(cinema, "Erreur pendant la suppression de la salle");
			} else {
				JOptionPane.showMessageDialog(cinema, "Suppression effectuée");
			}
		} else if (e.getSource() == cinema.getBtUpdateSalle()) {
			Salle updateSalle = updatesalle();
			if (updateSalle == null) {
				JOptionPane.showMessageDialog(cinema, "Erreur pendant la mise à jour de la salle");
			} else {
				JOptionPane.showMessageDialog(cinema, "Mise à jour effectuée");
			}
		} else if (e.getSource() == cinema.getBtUpdateCinema()) {
			Cinema cineUpdate = updatecinema();
			if (cineUpdate == null) {
				JOptionPane.showMessageDialog(cinema, "Erreur pendant la mise à jour du cinéma");
			} else {
				JOptionPane.showMessageDialog(cinema, "Mise à jour effectuée");
			}
		} else if (e.getSource() == cinema.getBtDelCinema()) {

		}

	}

	public void showadminpage() {
		cinema.getCinego().getCl().show(cinema.getCinego().getContent(), "Admin");
	}

	public List<Cinema> refreshcinemas() {
		cinema.clearcine();
		CinemaDAO cinedao = new CinemaDAO();
		List<Cinema> cine = cinedao.getAll();
		return cine;
	}

	public List<Salle> refreshsalles() {
		cinema.clearsalles();
		SallesDAO sallesdao = new SallesDAO();
		CinemaDAO cinedao = new CinemaDAO();
		String nomCine = cinema.getSelectedCinema();
		int idcine = cinedao.findIdByNom(nomCine);
		List<Salle> salles = sallesdao.getAllByCine(idcine);
		return salles;
	}

	public Salle detailsSalle() {
		SallesDAO sallesdao = new SallesDAO();
		CinemaDAO cinedao = new CinemaDAO();
		String nomCine = cinema.getSelectedCinema();
		System.out.println(nomCine);
		int idcine = cinedao.findIdByNom(nomCine);
		System.out.println(idcine);
		int numsalle = Integer.parseInt(cinema.getSelectedSalle());
		System.out.println(numsalle);
		Salle salle = sallesdao.getOneByNumSalle(idcine, numsalle);
		return salle;
	}

	public Cinema detailsCinema() {
		CinemaDAO cinedao = new CinemaDAO();
		String nomCine = cinema.getSelectedCinema();
		Cinema cine = cinedao.findByNom(nomCine);
		return cine;
	}

	public boolean deletesalle() {
		SallesDAO sallesdao = new SallesDAO();
		Salle salle = new Salle(cinema.getIdSalle());
		boolean delete = sallesdao.remove(salle);
		return delete;
	}

	public Salle updatesalle() {
		SallesDAO sallesdao = new SallesDAO();
		Salle salle = new Salle(cinema.getIdSalle());
		Salle updateSalle = sallesdao.saveOrUpdate(salle);
		return updateSalle;
	}

	public Cinema updatecinema() {
		CinemaDAO cinedao = new CinemaDAO();
		Cinema cineupdate = new Cinema(cinema.getIdCine());
		Cinema update = cinedao.saveOrUpdate(cineupdate);
		return update;
	}

}
