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
import dao.FilmsDAO;
import dao.GenreDAO;
import dao.MaterielDAO;
import dao.SallesDAO;
import dao.UtilisateurDAO;
import metier.Cinema;
import metier.Film;
import metier.Genre;
import metier.Salle;
import metier.Utilisateur;
import panels.PanelAdminPage;

/**
 *
 * @author Bastien
 */
public class EvtPageAdmin implements ActionListener {

	PanelAdminPage admin;

	public EvtPageAdmin(PanelAdminPage panelAdminPage) {
		this.admin = panelAdminPage;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == admin.getBtCreerSalle()) {
			showcreationsalle();
		} else if (e.getSource() == admin.getBtGestionClients()) {
			showgestionclients();
		} else if (e.getSource() == admin.getBtImportSalle()) {
			showimportsalle();
		} else if (e.getSource() == admin.getBtGestionSalle()) {
			showgestionsalles();
		} else if (e.getSource() == admin.getBtGestionAdmins()) {
			showgestionadmin();
		} else if (e.getSource() == admin.getBtGestionSeances()) {
			showgestionseances();
		} else if (e.getSource() == admin.getBtGestionFilms()) {
			showgestionfilms();
		} else if (e.getSource() == admin.getBtLogout()) {
			logout();
		}
	}

	@SuppressWarnings("unchecked")
	public void showgestionclients() {
		List<Cinema> cinelist = refreshcinemas();
		List<Genre> genrelist = refreshgenre();
		List<Utilisateur> clients = refreshclients();
		admin.getCinego().getClients().clearcb();

		if (clients == null) {
			JOptionPane.showMessageDialog(admin, "Erreur pendant la récupération de la liste des clients");
		} else {
			for (int i = 0; i < clients.size(); i++) {
				admin.getCinego().getPanelGestionClients().getCbClientList().addItem(clients.get(i).getNumFidélité()
						+ ": " + clients.get(i).getNom() + " " + clients.get(i).getPrenom());
			}
		}
		if (cinelist == null) {
			JOptionPane.showMessageDialog(admin, "Erreur pendant la récupération de la liste des cinémas");
		} else {
			for (Iterator<Cinema> i = cinelist.iterator(); i.hasNext();) {
				Cinema cinema = i.next();
				admin.getCinego().getClients().getCbCinePref().addItem(cinema.getNomcinema());
			}
		}
		if (genrelist == null) {
			JOptionPane.showMessageDialog(admin, "Erreur pendant la récupération de la liste des genres");
		} else {
			for (Iterator<Genre> i = genrelist.iterator(); i.hasNext();) {
				Genre genre = i.next();
				admin.getCinego().getClients().getCbGenrePref().addItem(genre.getGenre());
			}
		}
		admin.getCinego().getCl().show(admin.getCinego().getContent(), "GestionClients");
	}

	public void showimportsalle() {
		admin.getCinego().getCl().show(admin.getCinego().getContent(), "Importsalle");
	}

	@SuppressWarnings("unchecked")
	public void showgestionseances() {
		admin.getCinego().getCl().show(admin.getCinego().getContent(), "GestionSeances");
		List<Cinema> cinelist = refreshcinemas();
		List<Film> filmslist = refreshfilms();

		if (cinelist == null) {
			JOptionPane.showMessageDialog(admin, "Erreur pendant la récupération de la liste des cinémas");
		} else {
			for (Iterator<Cinema> i = cinelist.iterator(); i.hasNext();) {
				Cinema cinema = i.next();
				admin.getCinego().getPanelGestionSeances().getCbCinema().addItem(cinema.getNomcinema());
			}
		}

		List<Film> filmsalaffiche = refreshfilmsalaffiche();
		if (filmslist == null) {
			JOptionPane.showMessageDialog(admin, "Erreur pendant la récupération de la liste des films");
		} else {
			for (Iterator<Film> i = filmsalaffiche.iterator(); i.hasNext();) {
				Film f = i.next();
				admin.getCinego().getPanelGestionSeances().getCbFilms().addItem(f.getTitre());
			}
		}

	}

	@SuppressWarnings("unchecked")
	public void showgestionadmin() {
		admin.getCinego().getPanelGestionAdmin().clearCb();
		List<Utilisateur> admlist = refreshadmin();
		if (admlist == null) {
			JOptionPane.showMessageDialog(admin, "Erreur pendant la récupération de la liste des administrateurs");
		} else {
			for (int i = 0; i < admlist.size(); i++) {
				admin.getCinego().getPanelGestionAdmin().getCbListeAdmin().addItem(admlist.get(i).getNumFidélité());
			}
		}

		admin.getCinego().getCl().show(admin.getCinego().getContent(), "GestionAdmin");
	}

	@SuppressWarnings("unchecked")
	public void showgestionsalles() {
		List<String> screenlist = refreshecran();
		if (screenlist == null) {
			JOptionPane.showMessageDialog(admin, "Erreur pendant la récupération de la liste des écrans");
		} else {
			for (int i = 0; i < screenlist.size(); i++) {
				admin.getCinego().getPanelGestionCinema().getCbTypeEcran().addItem(screenlist.get(i));
			}
		}

		List<String> soundlist = refreshson();
		if (soundlist == null) {
			JOptionPane.showMessageDialog(admin, "Erreur pendant la récupération de la liste des types de son");
		} else {
			for (int i = 0; i < soundlist.size(); i++) {
				admin.getCinego().getPanelGestionCinema().getCbTypeSon().addItem(soundlist.get(i));
			}
		}
		admin.getCinego().getCl().show(admin.getCinego().getContent(), "GererSalles");

	}

	@SuppressWarnings("unchecked")
	public void showgestionfilms() {
		List<Film> filmslist = refreshfilms();
		if (filmslist == null) {
			JOptionPane.showMessageDialog(admin, "Erreur pendant la récupération de la liste des films");
		} else {
			for (Iterator<Film> i = filmslist.iterator(); i.hasNext();) {
				Film f = i.next();
				admin.getCinego().getPanelGestionFilms().getCbFilmsDispo().addItem(f.getTitre());
			}
		}
		List<Film> filmsalaffiche = refreshfilmsalaffiche();
		if (filmslist == null) {
			JOptionPane.showMessageDialog(admin, "Erreur pendant la récupération de la liste des films");
		} else {
			for (Iterator<Film> i = filmsalaffiche.iterator(); i.hasNext();) {
				Film f = i.next();
				admin.getCinego().getPanelGestionFilms().getCbFilmsAffiche().addItem(f.getTitre());
			}
		}
		admin.getCinego().getCl().show(admin.getCinego().getContent(), "GestionFilms");
	}

	@SuppressWarnings("unchecked")
	public void showcreationsalle() {
		List<Cinema> cinelist = refreshcinemas();
		if (cinelist == null) {
			JOptionPane.showMessageDialog(admin, "Erreur pendant la récupération de la liste des cinémas");
		} else {
			for (Iterator<Cinema> i = cinelist.iterator(); i.hasNext();) {
				Cinema cinema = i.next();
				admin.getCinego().getNewSalle().getCbCineRattachement().addItem(cinema.getNomcinema());
			}
		}
		List<String> screenlist = refreshecran();
		if (screenlist == null) {
			JOptionPane.showMessageDialog(admin, "Erreur pendant la récupération de la liste des écrans");
		} else {
			for (int i = 0; i < screenlist.size(); i++) {
				admin.getCinego().getNewSalle().getCbTypeEcran().addItem(screenlist.get(i));
			}
		}
		List<String> soundlist = refreshson();
		if (soundlist == null) {
			JOptionPane.showMessageDialog(admin, "Erreur pendant la récupération de la liste des types de son");
		} else {
			for (int i = 0; i < soundlist.size(); i++) {

				admin.getCinego().getNewSalle().getCdTypeSon().addItem(soundlist.get(i));
			}
		}

		admin.getCinego().getCl().show(admin.getCinego().getContent(), "NewSalle");
	}

	public List<Cinema> refreshcinemas() {
		CinemaDAO cinedao = new CinemaDAO();
		List<Cinema> cine = cinedao.getAll();
		return cine;
	}

	public List<Genre> refreshgenre() {
		GenreDAO genredao = new GenreDAO();
		List<Genre> genre = genredao.getAll();
		return genre;
	}

	public List<String> refreshecran() {
		MaterielDAO matosdao = new MaterielDAO();
		List<String> listeecran = matosdao.getAllEcran();
		return listeecran;
	}

	public List<String> refreshson() {
		MaterielDAO matosdao = new MaterielDAO();
		List<String> listeson = matosdao.getAllSon();
		return listeson;
	}

	public List<Utilisateur> refreshadmin() {
		UtilisateurDAO utildao = new UtilisateurDAO();
		List<Utilisateur> listeadmin = utildao.getAllAdmin();
		return listeadmin;
	}

	public List<Utilisateur> refreshclients() {
		UtilisateurDAO utildao = new UtilisateurDAO();
		List<Utilisateur> listeclients = utildao.getAllClients();
		return listeclients;
	}

	public void logout() {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment vous déconnecter ?",
				"Confirmation", dialogButton);
		if (dialogResult == JOptionPane.YES_OPTION) {
			admin.getCinego().getCl().show(admin.getCinego().getContent(), "Connexion");
			admin.getCinego().getPanelLogin().setTbPassword("");
		}
	}

	public List<Film> refreshfilms() {
		FilmsDAO filmdao = new FilmsDAO();
		List<Film> listefilm = filmdao.getAll();
		filmdao.getAlaffiche();
		return listefilm;
	}

	public List<Film> refreshfilmsalaffiche() {
		FilmsDAO filmdao = new FilmsDAO();
		List<Film> filmalaffiche = filmdao.getAlaffiche();
		return filmalaffiche;
	}

	public List<Salle> refreshsalles(String nomCine) {
		SallesDAO sallesdao = new SallesDAO();
		CinemaDAO cinedao = new CinemaDAO();
		int idcine = cinedao.findIdByNom(nomCine);
		List<Salle> salles = sallesdao.getAllByCine(idcine);
		return salles;
	}
}
