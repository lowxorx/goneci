package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import dao.SeancesDAO;
import metier.Séance;
import panels.PanelReservation;

public class EvePanelReservation implements ActionListener {

	private PanelReservation panelReserv;

	public EvePanelReservation(PanelReservation panelReservationFilm) {

		this.panelReserv = panelReservationFilm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == panelReserv.getDateSeance()) {
			Date date = (Date) panelReserv.getDateSeance().getSelectedItem();
			refreshCombo(date, panelReserv.getIdFilm());

		}
		;

		if (e.getSource() == panelReserv.getBtnReservation()) {

			Date date = (Date) panelReserv.getDateSeance().getSelectedItem();
			String heureDebut = (String) panelReserv.getHeureSéance().getSelectedItem();
			int nbDePlaces = (int) panelReserv.getSpinnerNbPlace().getValue();

			if (String.valueOf(nbDePlaces).equals("0")) {

				JOptionPane.showMessageDialog(panelReserv, "Vous n'avez pas choisis de places !");

			} else {

				OuvrePageConnexion(date, panelReserv.getIdFilm(), heureDebut, nbDePlaces);

			}

		}

		if (e.getSource() == panelReserv.getBtnRetour()) {

			this.panelReserv.getPgPrinc().getCl().show(this.panelReserv.getPgPrinc().getCardLayoutContent(),
					"panelChoixFilm");

		}

		if (e.getSource() == panelReserv.getHeureSéance()) {

			int count = panelReserv.getHeureSéance().getItemCount();

			if (String.valueOf(count).equals("0")) {

			} else {

				System.out.println("Entré combo heure séance");
				Date date = (Date) panelReserv.getDateSeance().getSelectedItem();
				String heureDebut = (String) panelReserv.getHeureSéance().getSelectedItem();
				PeupleContenuSéance(date, panelReserv.getIdFilm(), heureDebut);

			}

		}

	}

	@SuppressWarnings("unchecked")
	public void refreshCombo(Date date, int idFilm) {

		ArrayList<Séance> dateHeureDébut = new ArrayList<Séance>();
		SeancesDAO dao = new SeancesDAO();
		dateHeureDébut = (ArrayList<Séance>) dao.SearchSeance(date, idFilm);

		panelReserv.getHeureSéance().removeAllItems();

		for (int i = 0; i < dateHeureDébut.size(); i++) {

			panelReserv.getHeureSéance().addItem(dateHeureDébut.get(i).getHeureDebut());

		}

	}

	public void OuvrePageConnexion(Date date, int idFilm, String heureDebut, int nbDePlaces) {

		SeancesDAO dao = new SeancesDAO();
		Séance séanceEncours;
		séanceEncours = dao.findSeance(date, idFilm, heureDebut);

		System.out.println(séanceEncours);

		this.panelReserv.getPgPrinc().getCl().show(this.panelReserv.getPgPrinc().getCardLayoutContent(),
				"panelReservationConnexion");

		this.panelReserv.getPgPrinc().getPanelCoReservation().setSéanceEncours(séanceEncours);
		this.panelReserv.getPgPrinc().getPanelCoReservation().setNbPlaces(nbDePlaces);

	}

	public void Retour() {

		this.panelReserv.getPgPrinc().getCl().show(this.panelReserv.getPgPrinc().getCardLayoutContent(),
				"panelChoixFilm");

	}

	public void PeupleContenuSéance(Date date, int idFilm, String heureDebut) {

		SeancesDAO dao = new SeancesDAO();
		Séance séanceEncours;

		séanceEncours = dao.findSeance(date, idFilm, heureDebut);

		this.panelReserv.getLblVersionTxt().setText(séanceEncours.getVersion());
		this.panelReserv.getChckbxis3d().setSelected(séanceEncours.isIs3D());

	}

}
