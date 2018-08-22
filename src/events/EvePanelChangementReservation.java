package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.ReservationsDAO;
import panels.PanelChangementReservation;

public class EvePanelChangementReservation implements ActionListener {

	private PanelChangementReservation panChangReservation;

	public EvePanelChangementReservation(PanelChangementReservation panChangementReservation) {

		this.panChangReservation = panChangementReservation;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == panChangReservation.getBtnRemboursement()) {

			int dialogueBouton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog(null,
					"Cette action effacera votre reservation et vous remboursera de la somme versé. voulez-vous continuer?",
					"confirmation", dialogueBouton);
			if (dialogResult == JOptionPane.YES_OPTION) {

				Remboursement();

			}

		}

		if (e.getSource() == panChangReservation.getBtnRetour()) {

			Retour();

		}

	}

	public void Remboursement() {

		ReservationsDAO reserDao = new ReservationsDAO();

		reserDao.remove(panChangReservation.getRéservationEnCours());

		panChangReservation.getPgPrinc().getCl().show(panChangReservation.getPgPrinc().getCardLayoutContent(),
				"paneldem");

	}

	public void Retour() {

		panChangReservation.getPgPrinc().getPanelCoReservation().getTextField().setText("");
		panChangReservation.getPgPrinc().getPanelCoReservation().getTextFieldNumAbo().setText("");
		panChangReservation.getPgPrinc().getCl().show(panChangReservation.getPgPrinc().getCardLayoutContent(),
				"PanelCoReservation");

	}
}
