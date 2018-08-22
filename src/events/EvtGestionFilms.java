/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import dao.FilmsDAO;
import dao.GenreDAO;
import metier.Film;
import panels.PanelGestionFilms;

/**
 *
 * @author Bastien
 */
public class EvtGestionFilms implements ActionListener {

	PanelGestionFilms films;

	public EvtGestionFilms(PanelGestionFilms panelGestionFilms) {
		this.films = panelGestionFilms;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == films.getBtRetour()) {
			showadminpage();
		} else if (e.getSource() == films.getCbFilmsDispo()) {
			String film = films.getSelectedFilmDispo();
			if (film != null) {
				refreshinfofilm(film);
			}
		} else if (e.getSource() == films.getBtMajFilm()) {
			majfilm();
		} else if (e.getSource() == films.getBtRefreshAlAffiche()) {
			films.clearCb();

			List<Film> filmsalaffiche = refreshalaffiche();
			if (filmsalaffiche == null) {
				JOptionPane.showMessageDialog(films, "Erreur pendant la récupération de la liste des films");
			} else {
				for (Iterator<Film> i = filmsalaffiche.iterator(); i.hasNext();) {
					Film f = i.next();
					films.getCbFilmsAffiche().addItem(f.getTitre());
				}
			}
			List<Film> filmslist = refreshfilms();
			System.out.println(filmslist);
			if (filmslist == null) {
				JOptionPane.showMessageDialog(films, "Erreur pendant la récupération de la liste des films");
			} else {
				for (int i = 0; i < filmslist.size(); i++) {
					films.getCinego().getPanelGestionFilms().getCbFilmsDispo().addItem(filmslist.get(i).getTitre());
				}
			}

		}
	}

	public void showadminpage() {
		films.getCinego().getCl().show(films.getCinego().getContent(), "Admin");
	}

	public void majfilm() {
		Film filmtoup = new Film();
		GenreDAO gdao = new GenreDAO();
		filmtoup.setaLaffiche(films.getCheckAffiche());
		filmtoup.setDateSortie(films.getTbDateSortie());
		filmtoup.setDurée(films.getTbDureeFilm());
		filmtoup.setGenre(films.getTbGenreFilm());
		filmtoup.setIdFilm(films.getIdFilm());
		filmtoup.setRéalisateur(films.getTbRealFilm());
		filmtoup.setSynopsys(films.getTbSynopsysFilm());
		filmtoup.setTitre(films.getTbTitreFilm());
		filmtoup.setUrlAffiche(films.getTbUrlAffiche());

		Boolean genreExist = gdao.findByNom(filmtoup.getGenre());
		if (genreExist == false) {
			gdao.addGenre(filmtoup.getGenre());
		}

		FilmsDAO fdao = new FilmsDAO();
		fdao.saveOrUpdate(filmtoup);
	}

	public List<Film> refreshalaffiche() {
		FilmsDAO filmdao = new FilmsDAO();
		List<Film> filmalaffiche = filmdao.getAlaffiche();
		return filmalaffiche;
	}

	public List<Film> refreshfilms() {
		FilmsDAO filmdao = new FilmsDAO();
		List<Film> listefilm = filmdao.getAll();
		return listefilm;
	}

	public void refreshinfofilm(String titre) {
		FilmsDAO filmsdao = new FilmsDAO();
		Film film = new Film();
		film = filmsdao.findByTitre(titre);
		if (film != null) {
			films.setIdFilm(film.getIdFilm());
			films.setTbDateSortie(film.getDateSortie());
			films.setTbDureeFilm(film.getDurée());
			films.setTbGenreFilm(film.getGenre());
			films.setTbRealFilm(film.getRéalisateur());
			films.setTbSynopsysFilm(film.getSynopsys());
			films.setTbTitreFilm(film.getTitre());
			films.setTbUrlAffiche(film.getUrlAffiche());
			if (film.isaLaffiche() == true) {
				films.setCheckAffiche(true);
			} else {
				films.setCheckAffiche(false);
			}
			String urlaffiche = film.getUrlAffiche();
			films.setUrlAffiche(urlaffiche);
			URL affiche = null;
			try {
				affiche = new URL("http://image.tmdb.org/t/p/w500" + urlaffiche);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			System.out.println(affiche);
			films.setLblAffiche(affiche);
		} else {
			JOptionPane.showMessageDialog(films, "Erreur pendant la récupération des infos du film");
		}
	}

}
