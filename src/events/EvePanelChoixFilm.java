package events;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.SeancesDAO;
import metier.Film;
import metier.Séance;
import panels.PanelChoixFilm;
import panels.PanelReservationFilm;

public class EvePanelChoixFilm implements ListSelectionListener {

	private PanelChoixFilm panelFilm;

	public EvePanelChoixFilm(PanelChoixFilm panelChoixFilm) {
		super();
		this.panelFilm = panelChoixFilm;
	}

	public EvePanelChoixFilm(PanelReservationFilm reservationFilm) {
		super();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		// if(e.getSource()== panelFilm.getListe())checkFilmSelected();
		if (!e.getValueIsAdjusting()) {
			checkFilmSelected();
		}
	}

	public void checkFilmSelected() {

		Film film = panelFilm.getListe().getSelectedValue();

		panelFilm.getPgPrinc().getCl().show(panelFilm.getPgPrinc().getCardLayoutContent(), "panelReservation");

		this.panelFilm.getPgPrinc().getPanelReservation().getNomFilm().setText(film.getTitre());

		URL affiche = null;
		try {
			affiche = new URL("http://image.tmdb.org/t/p/w500" + film.getUrlAffiche());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		ImageIcon icon = new ImageIcon(affiche);
		Image img = icon.getImage().getScaledInstance(320, 450, Image.SCALE_SMOOTH);
		ImageIcon icored = new ImageIcon(img);

		this.panelFilm.getPgPrinc().getPanelReservation().getImageFilm().setIcon(icored);
		this.panelFilm.getPgPrinc().getPanelReservation().getImageFilm().setText("");
		this.panelFilm.getPgPrinc().getPanelReservation().getTextPane().setText(film.getSynopsys());
		this.panelFilm.getPgPrinc().getPanelReservation().setIdFilm(film.getIdFilm());

		this.panelFilm.getPgPrinc().getPanelReservation().getHeureSéance().removeAllItems();
		this.panelFilm.getPgPrinc().getPanelReservation().getDateSeance().removeAllItems();

		ArrayList<Date> date = new ArrayList<Date>();

		Date dateDuJour = new Date();

		SeancesDAO seanceDao = new SeancesDAO();

		ArrayList<Séance> séances = new ArrayList<Séance>();

		séances = (ArrayList<Séance>) seanceDao.findByCineAndFilm(this.panelFilm.getPgPrinc().getCine().getIdCinema(),
				film.getIdFilm());

		for (int i = 0; i < séances.size(); i++) {

			if (séances.get(i).getDateSeance().before(dateDuJour) == false) {

				date.add(séances.get(i).getDateSeance());
			}
		}

		for (int i = 0; i < date.size(); i++) {

			this.panelFilm.getPgPrinc().getPanelReservation().setDefo(date.get(i));

		}
	}
}
