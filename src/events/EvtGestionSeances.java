package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import dao.CinemaDAO;
import dao.FilmsDAO;
import dao.SallesDAO;
import dao.SeancesDAO;
import metier.Cinema;
import metier.Film;
import metier.Salle;
import metier.Séance;
import panels.PanelGestionSeances;

public class EvtGestionSeances implements ActionListener {
	PanelGestionSeances seances;

	public EvtGestionSeances(PanelGestionSeances panelGestionSeances) {
		this.seances = panelGestionSeances;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == seances.getBtRefresh()) {
			seances.setModifSeance(false);
			seances.setIdSeance(0);
			seances.setIdSalle(0);
			refreshseances();
		} else if (e.getSource() == seances.getCbCinema()) {
			seances.setModifSeance(false);
			seances.setIdSeance(0);
			seances.setIdSalle(0);
			seances.getCbSalleProj().removeAllItems();
			refreshsalles();
		} else if (e.getSource() == seances.getBtRetour()) {
			showadminpage();
		} else if (e.getSource() == seances.getBtValidSc()) {
			creatOrUpSeance();
		} else if (e.getSource() == seances.getBtModif()) {
			modifseance();
		}
	}

	public void modifseance() {
		String[] idseance = seances.getCbSeancesDispo().getSelectedItem().toString().split(":");
		int ids = Integer.parseInt(idseance[0]);
		seances.setIdSeance(ids);
		seances.setModifSeance(true);
		System.out.println(ids);
		SeancesDAO sdao = new SeancesDAO();
		Séance seancetomod = sdao.findSeanceById(ids);
		String[] heured = seancetomod.getHeureDebut().split("h");
		seances.setCbHH(heured[0]);
		seances.setCbMM(heured[1]);
		String[] heuref = seancetomod.getHeureFin().split("h");
		seances.setCbHHf(heuref[0]);
		seances.setCbMMf(heuref[1]);

		seances.setCbSalleProj(String.valueOf(seancetomod.getSalle().getNuméro()));
		seances.setCbVersion(seancetomod.getVersion());

		if (seancetomod.isIs3D() == true) {
			seances.getChk3d().setSelected(true);
			seances.getChknum().setSelected(false);
		} else {
			seances.getChk3d().setSelected(false);
			seances.getChknum().setSelected(true);
		}

		seances.getCbFilms().setSelectedItem(seancetomod.getFilm().getTitre());
		String[] dateseance = seancetomod.getDateSeance().toString().split("-");
		String year = dateseance[0];
		String month = dateseance[1];
		String[] daysplit = dateseance[2].split(" ");
		String day = daysplit[0];
		seances.getDatePicker().getJFormattedTextField().setText(year + "-" + month + "-" + day);
	}

	@SuppressWarnings("unchecked")
	public void refreshseances() {
		SallesDAO sdao = new SallesDAO();
		CinemaDAO cdao = new CinemaDAO();
		SeancesDAO sedao = new SeancesDAO();

		Salle salle = sdao.getOneByNumSalle(cdao.findIdByNom(seances.getSelectedCinema().toString()),
				Integer.parseInt(seances.getCbSalles().getSelectedItem().toString()));
		seances.setIdSalle(salle.getIdSalle());

		List<Séance> listseances = sedao.SearchSeanceByIdSalle(seances.getIdSalle());
		if (listseances == null) {
			JOptionPane.showMessageDialog(seances, "Erreur pendant la récupération de la liste des séances");
		} else {
			for (Iterator<Séance> i = listseances.iterator(); i.hasNext();) {
				Séance seance = i.next();
				seances.getCbSeancesDispo().addItem(seance.getIdSéance() + ": " + seance.getFilm().getTitre() + " -- "
						+ seance.getHeureDebut() + " - " + seance.getHeureFin());
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void refreshsalles() {
		List<Salle> cine = getsalles();
		if (cine == null) {
			JOptionPane.showMessageDialog(seances, "Erreur pendant la récupération de la liste des salles");
		} else {
			for (Iterator<Salle> i = cine.iterator(); i.hasNext();) {
				Salle salle = i.next();
				seances.getCbSalles().addItem((String.valueOf((salle.getNuméro()))));
				seances.getCbSalleProj().addItem((String.valueOf((salle.getNuméro()))));
			}
		}
	}

	public List<Salle> getsalles() {
		seances.clearsalles();
		SallesDAO sallesdao = new SallesDAO();
		CinemaDAO cinedao = new CinemaDAO();
		String nomCine = seances.getSelectedCinema();
		int idcine = cinedao.findIdByNom(nomCine);
		List<Salle> salles = sallesdao.getAllByCine(idcine);
		return salles;
	}

	public void showadminpage() {
		seances.getCinego().getCl().show(seances.getCinego().getContent(), "Admin");
	}

	public void creatOrUpSeance() {
		SeancesDAO sedao = new SeancesDAO();
		Séance seance = new Séance();

		CinemaDAO cdao = new CinemaDAO();
		Cinema cinema = cdao.findByNom(seances.getSelectedCinema());

		SallesDAO sdao = new SallesDAO();
		Salle salle = sdao.getOneByNumSalle(cinema.getIdCinema(),
				Integer.parseInt(seances.getCbSalleProj().getSelectedItem().toString()));

		FilmsDAO fdao = new FilmsDAO();
		Film film = fdao.findByTitre(seances.getCbFilms().getSelectedItem().toString());

		seance.setDateSeance(seances.getModel().getValue());
		seance.setDurée(film.getDurée());
		seance.setFilm(film);
		String heureDebut = seances.getCbHH().getSelectedItem().toString() + "h"
				+ seances.getCbMM().getSelectedItem().toString();
		System.out.println(heureDebut);
		seance.setHeureDebut(heureDebut);
		String heureFin = seances.getCbHHf().getSelectedItem().toString() + "h"
				+ seances.getCbMMf().getSelectedItem().toString();
		seance.setHeureFin(heureFin);
		if (seances.getChk3d().isSelected() == true) {
			seance.setIs3D(true);
		} else {
			seance.setIs3D(false);
		}
		seance.setPlaceDisponible(String.valueOf(salle.getNbPlacesTotal()));
		seance.setSalle(salle);
		seance.setVersion(seances.getCbVersion().getSelectedItem().toString());
		if (seances.isModifSeance() == true) {
			seance.setIdSéance(seances.getIdSeance());
			System.out.println("requete de modif de seance");
		}

		sedao.saveOrUpdate(seance);

	}
}
